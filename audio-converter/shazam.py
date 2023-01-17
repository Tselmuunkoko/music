import requests
import os

API_KEY = os.getenv("shazam_api_key")
HOST_URL = os.getenv("shazam_api_url")
BASE_URL = "https://shazam.p.rapidapi.com/"

def search(term):
    url = BASE_URL+"search"
    querystring = {"term": term}
    querystring = {"term":"kiss the rain","locale":"en-US","offset":"0","limit":"5"}
    headers = {
        "X-RapidAPI-Key": API_KEY,
        "X-RapidAPI-Host": HOST_URL
    }
    response = requests.request("GET", url, headers=headers, params=querystring)
    return response


def detect(base64Audio):
    url = BASE_URL + "songs/v2/detect"
    querystring = {"timezone":"America/Chicago","locale":"en-US"}
    uerystring = {"term":"kiss the rain","locale":"en-US","offset":"0","limit":"5"}
    headers = {
        "content-type": "text/plain",
        "X-RapidAPI-Key": API_KEY,
        "X-RapidAPI-Host": HOST_URL
    }
    response = requests.request("POST", url, data=base64Audio, headers=headers, params=querystring)
    return response