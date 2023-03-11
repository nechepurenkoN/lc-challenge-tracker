import json

import requests
from flask import Flask
import sys

app = Flask(__name__)
GRAPHQL_ENDPOINT_URL = "https://leetcode.com/graphql/"
HEADERS = {
    'Content-Type': 'application/json',
}


@app.route('/recentAcSubmissionList/<username>')
def recentAcSubmissionListByUsername(username):
    query = """
        query recentAcSubmissions($username: String!, $limit: Int!) {
          recentAcSubmissionList(username: $username, limit: $limit) {
            id
            title
            titleSlug
            timestamp
          }
        }
    """

    variables = {
        "username": username,
        "limit": 50
    }

    body = {
        "query": query,
        "variables": variables
    }

    response = requests.request("POST", GRAPHQL_ENDPOINT_URL, headers=HEADERS, data=json.dumps(body))
    return response.content.decode('utf-8')


if __name__ == '__main__':
    port = sys.argv[1] if len(sys.argv) > 1 else 8081
    app.run(port=port)
