#!/usr/bin/with-contenv bashio
# shellcheck shell=bash
# ==============================================================================
# Home Assistant Community Add-on: FRPC
# Configures NGINX to expose admin interface through ingress.
# ==============================================================================
# /etc/nginx/servers/ingress.conf
#"$(bashio::addon.ingress_entry)" |
bashio::var.json \
    port "$(bashio::addon.ingress_port)" \
    entry "$(bashio::addon.ingress_entry)" |
    tempio \
        -template /usr/share/tempio/nginx/ingress.conf.gtpl \
        -out /etc/nginx/servers/ingress.conf
