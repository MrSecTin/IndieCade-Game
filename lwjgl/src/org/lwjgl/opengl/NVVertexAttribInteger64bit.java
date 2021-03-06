/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

import java.nio.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Native bindings to the <a href="http://www.opengl.org/registry/specs/NV/vertex_attrib_integer_64bit.txt">NV_vertex_attrib_integer_64bit</a> extension.
 * 
 * <p>This extension provides support for specifying vertex attributes with 64-bit integer components, analagous to the 64-bit floating point support added
 * in EXT_vertex_attrib_64bit.</p>
 * 
 * <p>Additionally, it provides the VertexAttribLFormatNV entry point to specify bindless vertex attribute arrays with 64-bit integer or floating-point
 * components in conjunction with the NV_vertex_buffer_unified_memory extension.</p>
 * 
 * <p>Requires {@link GL30 OpenGL 3.0}, GLSL 1.30, {@link NVGPUShader5 NV_gpu_shader5} or equivalent functionality and {@link EXTVertexAttrib64bit EXT_vertex_attrib_64bit}.</p>
 */
public class NVVertexAttribInteger64bit {

	/** Accepted by the {@code type} parameter of VertexAttribLPointerEXT, VertexArrayVertexAttribLOffsetEXT, and VertexAttribLFormatNV. */
	public static final int
		GL_INT64_NV          = 0x140E,
		GL_UNSIGNED_INT64_NV = 0x140F;

	protected NVVertexAttribInteger64bit() {
		throw new UnsupportedOperationException();
	}

	static boolean isAvailable(GLCapabilities caps, java.util.Set<String> ext) {
		return checkFunctions(
			caps.glVertexAttribL1i64NV, caps.glVertexAttribL2i64NV, caps.glVertexAttribL3i64NV, caps.glVertexAttribL4i64NV, caps.glVertexAttribL1i64vNV, 
			caps.glVertexAttribL2i64vNV, caps.glVertexAttribL3i64vNV, caps.glVertexAttribL4i64vNV, caps.glVertexAttribL1ui64NV, caps.glVertexAttribL2ui64NV, 
			caps.glVertexAttribL3ui64NV, caps.glVertexAttribL4ui64NV, caps.glVertexAttribL1ui64vNV, caps.glVertexAttribL2ui64vNV, caps.glVertexAttribL3ui64vNV, 
			caps.glVertexAttribL4ui64vNV, caps.glGetVertexAttribLi64vNV, caps.glGetVertexAttribLui64vNV, 
			ext.contains("GL_NV_vertex_buffer_unified_memory") ? caps.glVertexAttribLFormatNV : -1L
		);
	}

	// --- [ glVertexAttribL1i64NV ] ---

	public static void glVertexAttribL1i64NV(int index, long x) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL1i64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJV(__functionAddress, index, x);
	}

	// --- [ glVertexAttribL2i64NV ] ---

	public static void glVertexAttribL2i64NV(int index, long x, long y) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL2i64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJV(__functionAddress, index, x, y);
	}

	// --- [ glVertexAttribL3i64NV ] ---

	public static void glVertexAttribL3i64NV(int index, long x, long y, long z) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL3i64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJJV(__functionAddress, index, x, y, z);
	}

	// --- [ glVertexAttribL4i64NV ] ---

	public static void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL4i64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJJJV(__functionAddress, index, x, y, z, w);
	}

	// --- [ glVertexAttribL1i64vNV ] ---

	public static void nglVertexAttribL1i64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL1i64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL1i64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 1);
		nglVertexAttribL1i64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL2i64vNV ] ---

	public static void nglVertexAttribL2i64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL2i64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL2i64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 2);
		nglVertexAttribL2i64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL3i64vNV ] ---

	public static void nglVertexAttribL3i64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL3i64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL3i64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 3);
		nglVertexAttribL3i64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL4i64vNV ] ---

	public static void nglVertexAttribL4i64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL4i64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL4i64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 4);
		nglVertexAttribL4i64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL1ui64NV ] ---

	public static void glVertexAttribL1ui64NV(int index, long x) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL1ui64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJV(__functionAddress, index, x);
	}

	// --- [ glVertexAttribL2ui64NV ] ---

	public static void glVertexAttribL2ui64NV(int index, long x, long y) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL2ui64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJV(__functionAddress, index, x, y);
	}

	// --- [ glVertexAttribL3ui64NV ] ---

	public static void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL3ui64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJJV(__functionAddress, index, x, y, z);
	}

	// --- [ glVertexAttribL4ui64NV ] ---

	public static void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL4ui64NV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIJJJJV(__functionAddress, index, x, y, z, w);
	}

	// --- [ glVertexAttribL1ui64vNV ] ---

	public static void nglVertexAttribL1ui64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL1ui64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL1ui64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 1);
		nglVertexAttribL1ui64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL2ui64vNV ] ---

	public static void nglVertexAttribL2ui64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL2ui64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL2ui64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 2);
		nglVertexAttribL2ui64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL3ui64vNV ] ---

	public static void nglVertexAttribL3ui64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL3ui64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL3ui64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 3);
		nglVertexAttribL3ui64vNV(index, memAddress(v));
	}

	// --- [ glVertexAttribL4ui64vNV ] ---

	public static void nglVertexAttribL4ui64vNV(int index, long v) {
		long __functionAddress = GL.getCapabilities().glVertexAttribL4ui64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIPV(__functionAddress, index, v);
	}

	public static void glVertexAttribL4ui64vNV(int index, LongBuffer v) {
		if ( CHECKS )
			checkBuffer(v, 4);
		nglVertexAttribL4ui64vNV(index, memAddress(v));
	}

	// --- [ glGetVertexAttribLi64vNV ] ---

	public static void nglGetVertexAttribLi64vNV(int index, int pname, long params) {
		long __functionAddress = GL.getCapabilities().glGetVertexAttribLi64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIIPV(__functionAddress, index, pname, params);
	}

	public static void glGetVertexAttribLi64vNV(int index, int pname, LongBuffer params) {
		if ( CHECKS )
			checkBuffer(params, 1);
		nglGetVertexAttribLi64vNV(index, pname, memAddress(params));
	}

	public static long glGetVertexAttribLi64NV(int index, int pname) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			LongBuffer params = stack.callocLong(1);
			nglGetVertexAttribLi64vNV(index, pname, memAddress(params));
			return params.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glGetVertexAttribLui64vNV ] ---

	public static void nglGetVertexAttribLui64vNV(int index, int pname, long params) {
		long __functionAddress = GL.getCapabilities().glGetVertexAttribLui64vNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIIPV(__functionAddress, index, pname, params);
	}

	public static void glGetVertexAttribLui64vNV(int index, int pname, LongBuffer params) {
		if ( CHECKS )
			checkBuffer(params, 1);
		nglGetVertexAttribLui64vNV(index, pname, memAddress(params));
	}

	public static long glGetVertexAttribLui64NV(int index, int pname) {
		MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
		try {
			LongBuffer params = stack.callocLong(1);
			nglGetVertexAttribLui64vNV(index, pname, memAddress(params));
			return params.get(0);
		} finally {
			stack.setPointer(stackPointer);
		}
	}

	// --- [ glVertexAttribLFormatNV ] ---

	public static void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
		long __functionAddress = GL.getCapabilities().glVertexAttribLFormatNV;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIIIIV(__functionAddress, index, size, type, stride);
	}

}