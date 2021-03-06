/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openal;

import java.nio.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/** Native bindings to ALC 1.0 functionality. */
public class ALC10 {

	/** General tokens. */
	public static final int
		ALC_INVALID = 0xFFFFFFFF,
		ALC_FALSE   = 0x0,
		ALC_TRUE    = 0x1;

	/** Context creation attributes. */
	public static final int
		ALC_FREQUENCY = 0x1007,
		ALC_REFRESH   = 0x1008,
		ALC_SYNC      = 0x1009;

	/** Error conditions. */
	public static final int
		ALC_NO_ERROR        = 0x0,
		ALC_INVALID_DEVICE  = 0xA001,
		ALC_INVALID_CONTEXT = 0xA002,
		ALC_INVALID_ENUM    = 0xA003,
		ALC_INVALID_VALUE   = 0xA004,
		ALC_OUT_OF_MEMORY   = 0xA005;

	/** String queries. */
	public static final int
		ALC_DEFAULT_DEVICE_SPECIFIER = 0x1004,
		ALC_DEVICE_SPECIFIER         = 0x1005,
		ALC_EXTENSIONS               = 0x1006;

	/** Integer queries. */
	public static final int
		ALC_MAJOR_VERSION   = 0x1000,
		ALC_MINOR_VERSION   = 0x1001,
		ALC_ATTRIBUTES_SIZE = 0x1002,
		ALC_ALL_ATTRIBUTES  = 0x1003;

	protected ALC10() {
		throw new UnsupportedOperationException();
	}

	static boolean isAvailable(ALCCapabilities caps) {
		return checkFunctions(
			caps.alcOpenDevice, caps.alcCloseDevice, caps.alcCreateContext, caps.alcMakeContextCurrent, caps.alcProcessContext, caps.alcSuspendContext, 
			caps.alcDestroyContext, caps.alcGetCurrentContext, caps.alcGetContextsDevice, caps.alcIsExtensionPresent, caps.alcGetProcAddress, 
			caps.alcGetEnumValue, caps.alcGetError, caps.alcGetString, caps.alcGetIntegerv
		);
	}

	// --- [ alcOpenDevice ] ---

	/**
	 * Allows the application to connect to a device.
	 * 
	 * <p>If the function returns {@code NULL}, then no sound driver/device has been found. The argument is a null terminated string that requests a certain device or
	 * device configuration. If {@code NULL} is specified, the implementation will provide an implementation specific default.</p>
	 *
	 * @param deviceSpecifier the requested device or device configuration
	 */
	public static long nalcOpenDevice(long deviceSpecifier) {
		long __functionAddress = ALC.getICD().alcOpenDevice;
		return invokePP(__functionAddress, deviceSpecifier);
	}

	/**
	 * Allows the application to connect to a device.
	 * 
	 * <p>If the function returns {@code NULL}, then no sound driver/device has been found. The argument is a null terminated string that requests a certain device or
	 * device configuration. If {@code NULL} is specified, the implementation will provide an implementation specific default.</p>
	 *
	 * @param deviceSpecifier the requested device or device configuration
	 */
	public static long alcOpenDevice(ByteBuffer deviceSpecifier) {
		if ( CHECKS )
			if ( deviceSpecifier != null ) checkNT1(deviceSpecifier);
		return nalcOpenDevice(memAddressSafe(deviceSpecifier));
	}

	/**
	 * Allows the application to connect to a device.
	 * 
	 * <p>If the function returns {@code NULL}, then no sound driver/device has been found. The argument is a null terminated string that requests a certain device or
	 * device configuration. If {@code NULL} is specified, the implementation will provide an implementation specific default.</p>
	 *
	 * @param deviceSpecifier the requested device or device configuration
	 */
	public static long alcOpenDevice(CharSequence deviceSpecifier) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer deviceSpecifierEncoded = deviceSpecifier == null ? null : stack.UTF8(deviceSpecifier);
			return nalcOpenDevice(memAddressSafe(deviceSpecifierEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ alcCloseDevice ] ---

	/**
	 * Allows the application to disconnect from a device.
	 * 
	 * <p>The return code will be ALC_TRUE or ALC_FALSE, indicating success or failure. Failure will occur if all the device's contexts and buffers have not been
	 * destroyed. Once closed, the {@code deviceHandle} is invalid.</p>
	 *
	 * @param deviceHandle the device to close
	 */
	public static boolean alcCloseDevice(long deviceHandle) {
		long __functionAddress = ALC.getICD().alcCloseDevice;
		if ( CHECKS )
			checkPointer(deviceHandle);
		return invokePZ(__functionAddress, deviceHandle);
	}

	// --- [ alcCreateContext ] ---

	/**
	 * Creates an AL context.
	 *
	 * @param deviceHandle a valid device
	 * @param attrList     null or a zero terminated list of integer pairs composed of valid ALC attribute tokens and requested values. One of:<br><table><tr><td>{@link #ALC_FREQUENCY FREQUENCY}</td><td>{@link #ALC_REFRESH REFRESH}</td><td>{@link #ALC_SYNC SYNC}</td><td>{@link ALC11#ALC_MONO_SOURCES MONO_SOURCES}</td><td>{@link ALC11#ALC_STEREO_SOURCES STEREO_SOURCES}</td></tr></table>
	 */
	public static long nalcCreateContext(long deviceHandle, long attrList) {
		long __functionAddress = ALC.getICD().alcCreateContext;
		if ( CHECKS )
			checkPointer(deviceHandle);
		return invokePPP(__functionAddress, deviceHandle, attrList);
	}

	/**
	 * Creates an AL context.
	 *
	 * @param deviceHandle a valid device
	 * @param attrList     null or a zero terminated list of integer pairs composed of valid ALC attribute tokens and requested values. One of:<br><table><tr><td>{@link #ALC_FREQUENCY FREQUENCY}</td><td>{@link #ALC_REFRESH REFRESH}</td><td>{@link #ALC_SYNC SYNC}</td><td>{@link ALC11#ALC_MONO_SOURCES MONO_SOURCES}</td><td>{@link ALC11#ALC_STEREO_SOURCES STEREO_SOURCES}</td></tr></table>
	 */
	public static long alcCreateContext(long deviceHandle, IntBuffer attrList) {
		if ( CHECKS )
			if ( attrList != null ) checkNT(attrList);
		return nalcCreateContext(deviceHandle, memAddressSafe(attrList));
	}

	// --- [ alcMakeContextCurrent ] ---

	/**
	 * Makes a context current with respect to OpenAL operation.
	 * 
	 * <p>The context parameter can be {@code NULL} or a valid context pointer. Using {@code NULL} results in no context being current, which is useful when shutting OpenAL down.
	 * The operation will apply to the device that the context was created for.</p>
	 * 
	 * <p>For each OS process (usually this means for each application), only one context can be current at any given time. All AL commands apply to the current
	 * context. Commands that affect objects shared among contexts (e.g. buffers) have side effects on other contexts.</p>
	 *
	 * @param context the context to make current
	 */
	public static boolean alcMakeContextCurrent(long context) {
		long __functionAddress = ALC.getICD().alcMakeContextCurrent;
		return invokePZ(__functionAddress, context);
	}

	// --- [ alcProcessContext ] ---

	/**
	 * The current context is the only context accessible to state changes by AL commands (aside from state changes affecting shared objects). However,
	 * multiple contexts can be processed at the same time. To indicate that a context should be processed (i.e. that internal execution state such as the
	 * offset increments are to be performed), the application uses {@code alcProcessContext}.
	 * 
	 * <p>Repeated calls to alcProcessContext are legal, and do not affect a context that is already marked as processing. The default state of a context created
	 * by alcCreateContext is that it is processing.</p>
	 *
	 * @param context the context to mark for processing
	 */
	public static void alcProcessContext(long context) {
		long __functionAddress = ALC.getICD().alcProcessContext;
		if ( CHECKS )
			checkPointer(context);
		invokePV(__functionAddress, context);
	}

	// --- [ alcSuspendContext ] ---

	/**
	 * The application can suspend any context from processing (including the current one). To indicate that a context should be suspended from processing
	 * (i.e. that internal execution state such as offset increments are not to be changed), the application uses {@code alcSuspendContext}.
	 * 
	 * <p>Repeated calls to alcSuspendContext are legal, and do not affect a context that is already marked as suspended.</p>
	 *
	 * @param context the context to mark as suspended
	 */
	public static void alcSuspendContext(long context) {
		long __functionAddress = ALC.getICD().alcSuspendContext;
		if ( CHECKS )
			checkPointer(context);
		invokePV(__functionAddress, context);
	}

	// --- [ alcDestroyContext ] ---

	/**
	 * Destroys a context.
	 * 
	 * <p>The correct way to destroy a context is to first release it using alcMakeCurrent with a {@code NULL} context. Applications should not attempt to destroy a
	 * current context – doing so will not work and will result in an ALC_INVALID_OPERATION error. All sources within a context will automatically be deleted
	 * during context destruction.</p>
	 *
	 * @param context the context to destroy
	 */
	public static void alcDestroyContext(long context) {
		long __functionAddress = ALC.getICD().alcDestroyContext;
		if ( CHECKS )
			checkPointer(context);
		invokePV(__functionAddress, context);
	}

	// --- [ alcGetCurrentContext ] ---

	/** Queries for, and obtains a handle to, the current context for the application. If there is no current context, {@code NULL} is returned. */
	public static long alcGetCurrentContext() {
		long __functionAddress = ALC.getICD().alcGetCurrentContext;
		return invokeP(__functionAddress);
	}

	// --- [ alcGetContextsDevice ] ---

	/**
	 * Queries for, and obtains a handle to, the device of a given context.
	 *
	 * @param context the context to query
	 */
	public static long alcGetContextsDevice(long context) {
		long __functionAddress = ALC.getICD().alcGetContextsDevice;
		if ( CHECKS )
			checkPointer(context);
		return invokePP(__functionAddress, context);
	}

	// --- [ alcIsExtensionPresent ] ---

	/**
	 * Verifies that a given extension is available for the current context and the device it is associated with.
	 * 
	 * <p>Invalid and unsupported string tokens return ALC_FALSE. A {@code NULL} deviceHandle is acceptable. {@code extName} is not case sensitive – the implementation
	 * will convert the name to all upper-case internally (and will express extension names in upper-case).</p>
	 *
	 * @param deviceHandle the device to query
	 * @param extName      the extension name
	 */
	public static boolean nalcIsExtensionPresent(long deviceHandle, long extName) {
		long __functionAddress = ALC.getICD().alcIsExtensionPresent;
		return invokePPZ(__functionAddress, deviceHandle, extName);
	}

	/**
	 * Verifies that a given extension is available for the current context and the device it is associated with.
	 * 
	 * <p>Invalid and unsupported string tokens return ALC_FALSE. A {@code NULL} deviceHandle is acceptable. {@code extName} is not case sensitive – the implementation
	 * will convert the name to all upper-case internally (and will express extension names in upper-case).</p>
	 *
	 * @param deviceHandle the device to query
	 * @param extName      the extension name
	 */
	public static boolean alcIsExtensionPresent(long deviceHandle, ByteBuffer extName) {
		if ( CHECKS )
			checkNT1(extName);
		return nalcIsExtensionPresent(deviceHandle, memAddress(extName));
	}

	/**
	 * Verifies that a given extension is available for the current context and the device it is associated with.
	 * 
	 * <p>Invalid and unsupported string tokens return ALC_FALSE. A {@code NULL} deviceHandle is acceptable. {@code extName} is not case sensitive – the implementation
	 * will convert the name to all upper-case internally (and will express extension names in upper-case).</p>
	 *
	 * @param deviceHandle the device to query
	 * @param extName      the extension name
	 */
	public static boolean alcIsExtensionPresent(long deviceHandle, CharSequence extName) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer extNameEncoded = stack.ASCII(extName);
			return nalcIsExtensionPresent(deviceHandle, memAddress(extNameEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ alcGetProcAddress ] ---

	/**
	 * Retrieves extension entry points.
	 * 
	 * <p>The application is expected to verify the applicability of an extension or core function entry point before requesting it by name, by use of
	 * {@link #alcIsExtensionPresent IsExtensionPresent}.</p>
	 * 
	 * <p>Entry points can be device specific, but are not context specific. Using a {@code NULL} device handle does not guarantee that the entry point is returned,
	 * even if available for one of the available devices.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param funcName     the function name
	 */
	public static long nalcGetProcAddress(long deviceHandle, long funcName) {
		long __functionAddress = ALC.getICD().alcGetProcAddress;
		return invokePPP(__functionAddress, deviceHandle, funcName);
	}

	/**
	 * Retrieves extension entry points.
	 * 
	 * <p>The application is expected to verify the applicability of an extension or core function entry point before requesting it by name, by use of
	 * {@link #alcIsExtensionPresent IsExtensionPresent}.</p>
	 * 
	 * <p>Entry points can be device specific, but are not context specific. Using a {@code NULL} device handle does not guarantee that the entry point is returned,
	 * even if available for one of the available devices.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param funcName     the function name
	 */
	public static long alcGetProcAddress(long deviceHandle, ByteBuffer funcName) {
		if ( CHECKS )
			checkNT1(funcName);
		return nalcGetProcAddress(deviceHandle, memAddress(funcName));
	}

	/**
	 * Retrieves extension entry points.
	 * 
	 * <p>The application is expected to verify the applicability of an extension or core function entry point before requesting it by name, by use of
	 * {@link #alcIsExtensionPresent IsExtensionPresent}.</p>
	 * 
	 * <p>Entry points can be device specific, but are not context specific. Using a {@code NULL} device handle does not guarantee that the entry point is returned,
	 * even if available for one of the available devices.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param funcName     the function name
	 */
	public static long alcGetProcAddress(long deviceHandle, CharSequence funcName) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer funcNameEncoded = stack.ASCII(funcName);
			return nalcGetProcAddress(deviceHandle, memAddress(funcNameEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ alcGetEnumValue ] ---

	/**
	 * Returns extension enum values.
	 * 
	 * <p>Enumeration/token values are device independent, but tokens defined for extensions might not be present for a given device. Using a {@code NULL} handle is
	 * legal, but only the tokens defined by the AL core are guaranteed. Availability of extension tokens depends on the ALC extension.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param enumName     the enum name
	 */
	public static int nalcGetEnumValue(long deviceHandle, long enumName) {
		long __functionAddress = ALC.getICD().alcGetEnumValue;
		return invokePPI(__functionAddress, deviceHandle, enumName);
	}

	/**
	 * Returns extension enum values.
	 * 
	 * <p>Enumeration/token values are device independent, but tokens defined for extensions might not be present for a given device. Using a {@code NULL} handle is
	 * legal, but only the tokens defined by the AL core are guaranteed. Availability of extension tokens depends on the ALC extension.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param enumName     the enum name
	 */
	public static int alcGetEnumValue(long deviceHandle, ByteBuffer enumName) {
		if ( CHECKS )
			checkNT1(enumName);
		return nalcGetEnumValue(deviceHandle, memAddress(enumName));
	}

	/**
	 * Returns extension enum values.
	 * 
	 * <p>Enumeration/token values are device independent, but tokens defined for extensions might not be present for a given device. Using a {@code NULL} handle is
	 * legal, but only the tokens defined by the AL core are guaranteed. Availability of extension tokens depends on the ALC extension.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param enumName     the enum name
	 */
	public static int alcGetEnumValue(long deviceHandle, CharSequence enumName) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			ByteBuffer enumNameEncoded = stack.ASCII(enumName);
			return nalcGetEnumValue(deviceHandle, memAddress(enumNameEncoded));
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ alcGetError ] ---

	/**
	 * Queries ALC errors.
	 * 
	 * <p>ALC uses the same conventions and mechanisms as AL for error handling. In particular, ALC does not use conventions derived from X11 (GLX) or Windows
	 * (WGL).</p>
	 * 
	 * <p>Error conditions are specific to the device, and (like AL) a call to alcGetError resets the error state.</p>
	 *
	 * @param deviceHandle the device to query
	 */
	public static int alcGetError(long deviceHandle) {
		long __functionAddress = ALC.getICD().alcGetError;
		return invokePI(__functionAddress, deviceHandle);
	}

	// --- [ alcGetString ] ---

	/**
	 * Obtains string value(s) from ALC.
	 * 
	 * <p><b>LWJGL note</b>: Use {@link ALUtil#getStringList} for those tokens that return multiple values.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param token        the information to query. One of:<br><table><tr><td>{@link #ALC_DEFAULT_DEVICE_SPECIFIER DEFAULT_DEVICE_SPECIFIER}</td><td>{@link #ALC_DEVICE_SPECIFIER DEVICE_SPECIFIER}</td><td>{@link #ALC_EXTENSIONS EXTENSIONS}</td></tr><tr><td>{@link ALC11#ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER CAPTURE_DEFAULT_DEVICE_SPECIFIER}</td><td>{@link ALC11#ALC_CAPTURE_DEVICE_SPECIFIER CAPTURE_DEVICE_SPECIFIER}</td></tr></table>
	 */
	public static long nalcGetString(long deviceHandle, int token) {
		long __functionAddress = ALC.getICD().alcGetString;
		return invokePIP(__functionAddress, deviceHandle, token);
	}

	/**
	 * Obtains string value(s) from ALC.
	 * 
	 * <p><b>LWJGL note</b>: Use {@link ALUtil#getStringList} for those tokens that return multiple values.</p>
	 *
	 * @param deviceHandle the device to query
	 * @param token        the information to query. One of:<br><table><tr><td>{@link #ALC_DEFAULT_DEVICE_SPECIFIER DEFAULT_DEVICE_SPECIFIER}</td><td>{@link #ALC_DEVICE_SPECIFIER DEVICE_SPECIFIER}</td><td>{@link #ALC_EXTENSIONS EXTENSIONS}</td></tr><tr><td>{@link ALC11#ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER CAPTURE_DEFAULT_DEVICE_SPECIFIER}</td><td>{@link ALC11#ALC_CAPTURE_DEVICE_SPECIFIER CAPTURE_DEVICE_SPECIFIER}</td></tr></table>
	 */
	public static String alcGetString(long deviceHandle, int token) {
		long __result = nalcGetString(deviceHandle, token);
		return memUTF8(__result);
	}

	// --- [ alcGetIntegerv ] ---

	/**
	 * Obtains integer value(s) from ALC.
	 *
	 * @param deviceHandle the device to query
	 * @param token        the information to query. One of:<br><table><tr><td>{@link #ALC_MAJOR_VERSION MAJOR_VERSION}</td><td>{@link #ALC_MINOR_VERSION MINOR_VERSION}</td><td>{@link #ALC_ATTRIBUTES_SIZE ATTRIBUTES_SIZE}</td><td>{@link #ALC_ALL_ATTRIBUTES ALL_ATTRIBUTES}</td><td>{@link ALC11#ALC_CAPTURE_SAMPLES CAPTURE_SAMPLES}</td></tr></table>
	 * @param size         the size of the {@code dest} buffer
	 * @param dest         the destination buffer
	 */
	public static void nalcGetIntegerv(long deviceHandle, int token, int size, long dest) {
		long __functionAddress = ALC.getICD().alcGetIntegerv;
		invokePIIPV(__functionAddress, deviceHandle, token, size, dest);
	}

	/**
	 * Obtains integer value(s) from ALC.
	 *
	 * @param deviceHandle the device to query
	 * @param token        the information to query. One of:<br><table><tr><td>{@link #ALC_MAJOR_VERSION MAJOR_VERSION}</td><td>{@link #ALC_MINOR_VERSION MINOR_VERSION}</td><td>{@link #ALC_ATTRIBUTES_SIZE ATTRIBUTES_SIZE}</td><td>{@link #ALC_ALL_ATTRIBUTES ALL_ATTRIBUTES}</td><td>{@link ALC11#ALC_CAPTURE_SAMPLES CAPTURE_SAMPLES}</td></tr></table>
	 * @param dest         the destination buffer
	 */
	public static void alcGetIntegerv(long deviceHandle, int token, IntBuffer dest) {
		nalcGetIntegerv(deviceHandle, token, dest.remaining(), memAddress(dest));
	}

	/**
	 * Obtains integer value(s) from ALC.
	 *
	 * @param deviceHandle the device to query
	 * @param token        the information to query. One of:<br><table><tr><td>{@link #ALC_MAJOR_VERSION MAJOR_VERSION}</td><td>{@link #ALC_MINOR_VERSION MINOR_VERSION}</td><td>{@link #ALC_ATTRIBUTES_SIZE ATTRIBUTES_SIZE}</td><td>{@link #ALC_ALL_ATTRIBUTES ALL_ATTRIBUTES}</td><td>{@link ALC11#ALC_CAPTURE_SAMPLES CAPTURE_SAMPLES}</td></tr></table>
	 */
	public static int alcGetInteger(long deviceHandle, int token) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			IntBuffer dest = stack.callocInt(1);
			nalcGetIntegerv(deviceHandle, token, 1, memAddress(dest));
			return dest.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

}