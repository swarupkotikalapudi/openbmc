FILESEXTRAPATHS_prepend := "${THISDIR}/linux-aspeed:"
SRC_URI += "file://yosemitev2.cfg"
SRC_URI += "file://0001-Yosemite-device-tree.patch"
SRC_URI += "file://0002-net-ncsi-Fix-gma-flag-setting-after-response.patch"
SRC_URI += "file://0003-net-ncsi-Send-device-address-as-source-address.patch"
SRC_URI += "file://0004-net-ncsi-Support-for-multi-host-mellanox-card.patch"
