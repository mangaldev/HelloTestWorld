import requests

for num in range(1714153000,1714154000):
    url = "https://egov.uscis.gov/casestatus/mycasestatus.do"

    payload = "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"appReceiptNum\"\r\n\r\nWAC"+str(num)+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--"
    headers = {
        'content-type': "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW",
        'cache-control': "no-cache",
        'postman-token': "8dd34699-fedc-39b2-5698-e96346399cc0"
    }

    response = requests.request("POST", url, data=payload, headers=headers)

    #print(response.text).encode('ascii', 'ignore')
    from lxml.html.soupparser import fromstring
    tree = fromstring(response.text)
    print tree.xpath("//html//body//div[2]//form//div//div[1]//div//div//div[2]//div[3]//h1//text()")