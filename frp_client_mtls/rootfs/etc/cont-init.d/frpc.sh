#!/usr/bin/env bashio
# shellcheck shell=bash

CONFIG=/data/frpc.ini
bashio::log.info "Configuring frpc..."
mkdir -p /data/confd
tempio \
    -conf /data/options.json \
    -template /usr/share/tempio/frpc.ini \
    -out "${CONFIG}"
