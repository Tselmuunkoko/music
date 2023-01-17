# SDE Music service
The project is about using Shazam open API service from RapidApi.com to detect pieces of music from a youtube search API. Also, users can globalize their search history, so the public can access it and discover new music that people are searching for.

## API LIST

| Name                 | Details                                                                 |
|----------------------|-------------------------------------------------------------------------|
| /music/detect        | takes webm audio raw data as input and return Shazam and Youtube result |
| /music/create/       | saves the search history of user                                        |
| /music/retrieve/{id} | gets music by id                                                        |
| /music/top           | gets top searches on the database that are globally available           |
| /music/delete/{id}   | deletes the music search history                                        |
| /music/share/{id}    | makes the music global on search                                        |

## Project Structure

```
├── README.md
├── audio-converter
│   ├── Dockerfile
│   ├── app.py
│   ├── config.py
│   ├── requirements.txt
│   ├── shazam.py
│   └── youtube.py
├── customer
│   ├── Dockerfile
│   ├── README.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
├── db
│   └── mongo-init.js
├── docker-compose.yml
└── front
    ├── Dockerfile
    ├── README.md
    ├── generate-react-cli.json
    ├── package.json
    ├── public
    ├── src
    └── tailwind.config.js
```

## Deployments
The project deployments are held using the docker-compose tool. Inside the project main, directory running the docker-compose up command will provide the local deployment.

#### Deploy on localhost
```
git clone https://github.com/Tselmuunkoko/music.git
cd music
docker compose up -d
```

#### Detect payload curl example
```
curl -XPOST
-H 'Accept: application/json, text/plain, */*' \
-H 'Authorization: Bearer token ' \
-H 'Content-Type: application/json' \
--data-raw '{"audio":"base64Audio"}' \
```
