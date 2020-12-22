import requests
import sys

from requests import HTTPError

print(sys.executable, sys.version)

try:
    response = requests.get('http://example.com/foo')
    response.raise_for_status()
    print(response)
except HTTPError as err:
    if err.response.status_code == 404:
        print("Not found")
    else:
        raise
