import requests

def search():
    url = "https://shazam.p.rapidapi.com/shazam-events/list"
    querystring = {"artistId":"73406786","l":"en-US","from":"2022-12-31","limit":"50","offset":"0"}
    headers = {
        "X-RapidAPI-Key": "c07d6c0b9bmsh3fdc2ab8d9ca0afp1a368ejsn5d6c5156b2d2",
        "X-RapidAPI-Host": "shazam.p.rapidapi.com"
    }
    response = requests.request("GET", url, headers=headers, params=querystring)
    print(response.text)


def detect(base64Audio):
    url = "https://shazam.p.rapidapi.com/songs/v2/detect"
    querystring = {"timezone":"America/Chicago","locale":"en-US"}
    headers = {
        "content-type": "text/plain",
        "X-RapidAPI-Key": "c07d6c0b9bmsh3fdc2ab8d9ca0afp1a368ejsn5d6c5156b2d2",
        "X-RapidAPI-Host": "shazam.p.rapidapi.com"
    }
    response = requests.request("POST", url, data=base64Audio, headers=headers, params=querystring)
    print(response.text)