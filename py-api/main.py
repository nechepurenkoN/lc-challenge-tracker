import requests
from flask import Flask

app = Flask(__name__)


@app.route('/<username>')
def graphql(username):
    url = "https://leetcode.com/graphql/"
    payload = '{\"query\":\"query recentAcSubmissions($username: String!, $limit: Int!) {\\r\\n  recentAcSubmissionList(username: $username, limit: $limit) {\\r\\n    id\\r\\n    title\\r\\n    titleSlug\\r\\n    timestamp\\r\\n  }\\r\\n}\\r\\n    \",\"variables\":{\"username\":\"' + username + '\",\"limit\":50}}'
    headers = {
        'Content-Type': 'application/json',
    }
    response = requests.request("POST", url, headers=headers, data=payload)
    return response.content.decode('utf-8')


if __name__ == '__main__':
    app.run(port=8081)
