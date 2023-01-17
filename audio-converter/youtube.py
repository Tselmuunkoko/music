import argparse, os
from dotenv import load_dotenv
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError

# Setup YouTube API
KEY = os.getenv('google_key')
YOUTUBE_API_SERVICE_NAME = 'youtube'
YOUTUBE_API_VERSION = 'v3'

load_dotenv()

def yt(query):
    if not KEY:
        return '"KEY" env var is required'
    youtube = build('youtube', 'v3', developerKey=KEY)

    # Get YouTube API results
    search_response = youtube.search().list(
        q= query or 'cats',
        type='video',
        part='id,snippet',
        maxResults=10
    ).execute()
    items = search_response['items']
    if not items:
        return 'Error: No YouTube results'

    # Sent an HTML page with the top ten videos
    def video_filter(api_video):
        title = api_video['snippet']['title']
        videoid = api_video['id']['videoId']
        url = f'https://youtu.be/{videoid}'
        return {
            'title': title,
            'url': url,
        }
    videos = list(map(video_filter, items))

    return {
        'results': videos
    }
