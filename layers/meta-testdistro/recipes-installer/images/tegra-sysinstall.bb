DESCRIPTION = "Installer tegraflash package"
LICENSE = "MIT"

COMPATIBLE_MACHINE = "(tegra)"

IMAGE_INSTALL = "packagegroup-core-boot tegra-sysinstall-tools haveged"
IMAGE_FEATURES = "empty-root-password allow-empty-password"
IMAGE_LINUGAS = ""

inherit core-image

IMAGE_FSTYPES = "tegraflash"
IMAGE_ROOTFS_SIZE = "131072"
KERNEL_ARGS_append = " root=PARTLABEL=INSTALLER"
KERNEL_ARGS_remove = "console=tty0"
ROOTFS_POSTPROCESS_COMMAND_prepend = "ensure_data_exists;"
ROOTFS_POSTPROCESS_COMMAND_remove = "mender_update_fstab_file;"
ROOTFS_POSTPROCESS_COMMAND_remove = "mender_create_scripts_version_file;"

ensure_data_exists() {
    [ -d "${IMAGE_ROOTFS}/data" ] || install -d "${IMAGE_ROOTFS}/data"
}
