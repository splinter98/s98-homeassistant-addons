server {
    listen {{ .port }} default_server;

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;
    proxy_set_header Authorization 'Basic YWRtaW46YWRtaW4=';
    proxy_set_header Accept-Encoding "";

    proxy_headers_hash_max_size 1024;
    proxy_headers_hash_bucket_size 128;


    location / {
        allow   172.30.32.2;
        deny    all;
        proxy_pass http://backend;
        proxy_redirect ~^/(.+)$ $real_scheme://$http_host{{ .entry }}/$1;
        
        sub_filter_once off;
        sub_filter_types *;

        sub_filter '/static/' '{{ .entry }}/static/';
        sub_filter '/favicon.ico' '{{ .entry }}/favicon.ico';
        sub_filter '/debug/' '{{ .entry }}/debug/';
        sub_filter '/healthz' '{{ .entry }}/healthz';

        sub_filter "top.window.location.href" "location.href";
    }
}
