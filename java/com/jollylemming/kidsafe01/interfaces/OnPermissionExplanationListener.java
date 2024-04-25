package com.jollylemming.kidsafe01.interfaces;

public interface OnPermissionExplanationListener {
    void onOk(int requestCode);

    void onCancel(int switchId);
}
