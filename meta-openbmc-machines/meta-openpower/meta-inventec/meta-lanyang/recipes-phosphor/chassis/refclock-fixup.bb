DESCRIPTION = "Lanyang host reference clock fixup"
PR = "r0"

inherit obmc-phosphor-systemd
inherit obmc-phosphor-license

TMPL = "op-refclock-fixup@.service"
INSTFMT = "op-refclock-fixup@{0}.service"
TGTFMT = "obmc-power-chassis-on@{0}.target"
FMT = "../${TMPL}:${TGTFMT}.requires/${INSTFMT}"

SYSTEMD_SERVICE_${PN} += "${TMPL}"
SYSTEMD_LINK_${PN} += "${@compose_list(d, 'FMT', 'OBMC_CHASSIS_INSTANCES')}"

SRC_URI += "file://fix_lanyang_refclock.sh"
RDEPENDS_${PN} += "i2c-tools"

do_install() {
        install -d ${D}${sbindir}
        install -m 0755 ${WORKDIR}/fix_lanyang_refclock.sh ${D}${sbindir}/fix_lanyang_refclock.sh
}
