import requests
from bs4 import BeautifulSoup


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
                url1 = 'https://pic.netbian.com/' + img
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
    r = requests.get(url1, timeout=100)
    data = r.content
    with open("F:/crawling/girl/" + str(count) + '.' + str(name) + '.jpg', 'wb') as f:
        f.write(data)
    print('已打印{}张图片'.format(count))


# for i in range(2,10):
#     url='https://tu.cnzol.com/meinv/index_'+str(i)+'.html'
#     imagespider(url)


# for i in range(2,10):
#     url='https://www.ivsky.com/tupian/meinv_t50/index_'+str(i)+'.html'
#     imagespider(url)

if __name__ == '__main__':
    #获取用户代理，模仿浏览器访问
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.146 Safari/537.36'}
    count = 0
    for i in range(1, 10):
        url = 'https://pic.netbian.com/4kmeinv/index_' + str(i) + '.html'
        imagespider(url)
