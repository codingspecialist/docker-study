## nginx dns 와 upstream

 Docker Compose를 사용하는 경우, 서비스명은 내부 DNS 레지스트리에 등록되며 컨테이너 간의 통신에 사용됩니다. 이것은 도커 컨테이너 내부에서 동작하는 것으로 인식되어, /etc/hosts 파일과 유사한 역할을 하게 됩니다.

기본적으로 Docker Compose는 각 서비스를 별도의 네트워크에 연결하고, 서비스명으로 해당 서비스의 컨테이너를 찾을 수 있도록 DNS 레지스트리를 설정합니다. 따라서 컨테이너 내부에서 서비스명을 사용하면 내부 DNS에 의해 해당 서비스의 컨테이너 IP 주소를 찾아갈 수 있게 됩니다.

location에 dns이름을 정의하여 찾을 수는 없고 upstream에 dns이름을 정의하여 설정한뒤
location에서 upstream이름으로 경로를 설정할 수 있습니다.
이때 dns이름은 docker-compose에 정의된 서비스명입니다.


## nginx URL 재작성
proxy_pass 지시문은 /api/로 들어오는 모든 요청을 http://backend으로 전달합니다. 이때, Nginx는 원본 요청의 URL 경로를 그대로 유지합니다. 따라서 100.5.5.5:80/api/product로 들어오는 요청은 실제로 http://backend/api/product로 전달됩니다.

## api 주소를 지우고 싶다면?
location /api/ {
    proxy_set_header X-Original-URI $request_uri;  # 현재 요청의 원본 URI를 저장합니다.
    rewrite ^/api(/.*)$ $1 break;  # /api/를 제거합니다.
    proxy_pass http://backend;
    ...
}