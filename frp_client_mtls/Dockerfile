ARG FRPC_VERSION
ARG STEP_VERSION
ARG BUILD_FROM
FROM smallstep/step-cli:${STEP_VERSION} as step
FROM fatedier/frpc:${FRPC_VERSION} as frpc
FROM ${BUILD_FROM}

RUN \
    apk --no-cache add \
    nginx \
    \
    && mkdir -p /run/nginx

COPY --from=step /usr/local/bin/step /usr/local/bin/
COPY --from=frpc /usr/bin/frpc /usr/local/bin/
COPY rootfs /
