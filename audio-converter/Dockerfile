# syntax=docker/dockerfile:1.4
FROM python:3.10-alpine

WORKDIR /app
RUN apk update
RUN apk add  --no-cache ffmpeg
COPY requirements.txt /app
RUN pip3 install -r requirements.txt

COPY . /app

ENTRYPOINT flask run --host=0.0.0.0 --port=8000