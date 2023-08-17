### 리엑트 실행하기
npm start

### 리엑트 빌드하기 (html 파일 만들기)
npm run build

### Dockerfile 만들어서 이미지 빌드하기
docker build . -t react-app

### nginx 실행하기
docker run -p 80:80 -dit react-app

```text
FROM nginx:1.16.0-alpine
COPY ./build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

docker run -dit -p 80:80 react-app
