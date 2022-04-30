ARG BUILD_FROM
FROM ${BUILD_FROM}

# LABEL \
#     io.hass.version="${BUILD_VERION}" \
#     io.hass.type="addon" \
#     io.hass.arch="armv7|aarch64|i386|amd64"

RUN apk add --no-cache -X http://dl-cdn.alpinelinux.org/alpine/edge/community step-cli

COPY rootfs /