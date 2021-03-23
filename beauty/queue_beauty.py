import requests,time,threading
from queue import Queue
from bs4 import BeautifulSoup


# 处理队列中的url
def task():
    global q
    while True:  # 循环，使线程一直从q中获取url
        url = q.get()
        imagespider(url)
        q.task_done()


#定位到美女图片的下载地址以及图片名字
def imagespider(url):
    global headers
    try:
        urls = []
        r = requests.get(url, headers=headers)
        #由于某些网站编码不一定是utf-8，需要译码
        r.content.decode('GBK')
        r.encoding = 'utf-8'
        soup = BeautifulSoup(r.content, 'lxml')
        lis = soup.select("li a img")
        for li in lis:
            try:
                img = li['src']
                name = li['alt']
                url1 = 'https://' + 'pic.netbian.com/' + img
                if url1 not in urls:
                    download(url1, name)

            except Exception as err:
                print(err)
    except:
        return ''


#下载美女图片到本地文件
def download(url1, name ):
    global count
    count = count + 1
    r = requests.get(url1,timeout=100)
    data = r.content
    with open("F:/crawling/girl/" + str(count) + '.' + str(name) + '.jpg', 'wb') as f:
        f.write(data)
    print('已打印第{}张图片'.format(count))


if __name__ == '__main__':
    t_start = time.time()
    #获取用户代理，模仿浏览器访问
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.146 Safari/537.36'}
    count = 0

    #任务队列
    q = Queue()
    for i in range(1, 50):  # 为q队列添加待爬取的url
        url = 'https://' + 'pic.netbian.com/4kmeinv/index_' + str(i) + '.html'
        q.put(url)

    #多线程
    thread_list = []
    for i in range(8):  # 8个线程
        t = threading.Thread(target=task)
        thread_list.append(t)

    for t in thread_list:
        t.setDaemon(True)  # 子线程会在不重要的主线程结束，子线程结束
        t.start()

    q.join()  # 让主线程阻塞，等待队列任务全部完成，防止主线程结束导致子线程也被杀死
    t_end = time.time()
    print('the queue way take %s s' % (t_end - t_start))
