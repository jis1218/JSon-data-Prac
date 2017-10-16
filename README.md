##### HttpURLConnection 클래스를 통해 github의 users JSon을 가지고 온다.
##### github의 https://api.github.com/users 안에는 다음과 같이 담겨있다.
```
[
  {
    "login": "mojombo",
    "id": 1,
    "avatar_url": "https://avatars0.githubusercontent.com/u/1?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/mojombo",
    "html_url": "https://github.com/mojombo",
    "followers_url": "https://api.github.com/users/mojombo/followers",
    "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
    "gists_url": "https://api.github.com/users/mojombo/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
    "organizations_url": "https://api.github.com/users/mojombo/orgs",
    "repos_url": "https://api.github.com/users/mojombo/repos",
    "events_url": "https://api.github.com/users/mojombo/events{/privacy}",
    "received_events_url": "https://api.github.com/users/mojombo/received_events",
    "type": "User",
    "site_admin": false
  },
  ...
  ...
  ...
```

##### 이를 String 함수로 잘 하여 가져올 수도 있지만
##### GSon이라는 라이브러리를 이용하면 쉽게 가져올 수 있다. 또한 Image File의 Url의 경우 Glide라는 라이브러리를 이용하면 역시 쉽게 가져올 수 있다.
