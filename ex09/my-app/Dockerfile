FROM node:alpine as build
WORKDIR /app
COPY package.json /app
RUN npm install --silent
COPY . /app
RUN npm run build

FROM nginx
COPY --from=build  /app/build /usr/share/nginx/html
ENTRYPOINT ["nginx", "-g", "daemon off;"]
