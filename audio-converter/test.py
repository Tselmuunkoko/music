import requests

url = "https://shazam.p.rapidapi.com/search"

querystring = {"term":"kiss the rain","locale":"en-US","offset":"0","limit":"5"}

headers = {
	"X-RapidAPI-Key": "3862abc506msh2b9ef5c2e4b4e48p1c106fjsn341aa31feb22",
	"X-RapidAPI-Host": "shazam.p.rapidapi.com"
}

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)