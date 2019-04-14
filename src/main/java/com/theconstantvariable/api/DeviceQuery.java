package com.theconstantvariable.api;

import java.util.List;

/** Specifically for querying device farms, rather than browser/virtual machine set ups which do not have
 *  limitations - device farms are typically public, and devices cannot be 'captured' when in use by other
 *  users.
 */

public interface DeviceQuery<T> {

    public List<T> queryAllDevices();

    public List<T> queryAvailableDevices();

    public void populateMatchingDeviceEnvironments();

}
