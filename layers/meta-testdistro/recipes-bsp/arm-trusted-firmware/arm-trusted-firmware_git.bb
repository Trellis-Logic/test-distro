SRC_REPO ?= "github.com/madisongh/arm-trusted-firmware.git;protocol=https"
SRCBRANCH ?= "patches-l4t-r32.4.2"
SRC_URI = "git://${SRC_REPO};branch=${SRCBRANCH}"
SRCREV ?= "${AUTOREV}"
S = "${WORKDIR}/git"

inherit l4t_bsp

PV = "1.3-l4t-32.4.2+git${SRCPV}"

require recipes-bsp/arm-trusted-firmware/arm-trusted-firmware.inc
