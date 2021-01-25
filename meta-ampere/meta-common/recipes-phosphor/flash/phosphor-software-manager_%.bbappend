FILESEXTRAPATHS_prepend_mtjade := "${THISDIR}/${PN}:"

#PACKAGECONFIG[flash_bios] = "-Dhost-bios-upgrade=enabled, -Dhost-bios-upgrade=disabled"
PACKAGECONFIG[other_update] = "-Dother-upgrade=enabled, -Dother-upgrade=disabled"

PACKAGECONFIG_append_mtjade = " flash_bios other_update"

SYSTEMD_SERVICE_${PN}-updater += "${@bb.utils.contains('PACKAGECONFIG', 'flash_bios', 'obmc-flash-host-bios@.service', '', d)}"

SYSTEMD_SERVICE_${PN}-updater += " \
                                  obmc-update-scp-primary@.service \
                                  obmc-update-scp-secondary@.service \
				 "

SRC_URI += " \
            file://0001-Implement-Software.Extended-Version.patch \
            file://0002-Add-other-image-update-support.patch \
           "
