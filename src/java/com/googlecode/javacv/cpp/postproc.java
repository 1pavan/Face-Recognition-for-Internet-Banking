/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */

/*
 * Copyright (C) 2013 Samuel Audet
 *
 * This file is part of JavaCPP.
 *
 * JavaCPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * JavaCPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaCPP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;
import java.nio.*;

import static com.googlecode.javacv.cpp.avutil.*;

/**
 *
 * @author Samuel Audet
 */
@Properties(inherit=avutil.class, value={
    @Platform(cinclude="<libpostproc/postprocess.h>", link="postproc@.52"),
    @Platform(value="windows", preload="postproc-52") })
public class postproc {
    static { Loader.load(); }

/* Wrapper for header file /usr/local/include/libpostproc/postprocess.h */

/*
 * Copyright (C) 2001-2003 Michael Niedermayer (michaelni@gmx.at)
 *
 * This file is part of FFmpeg.
 *
 * FFmpeg is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * FFmpeg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FFmpeg; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

// #ifndef POSTPROC_POSTPROCESS_H
// #define POSTPROC_POSTPROCESS_H

/**
 * @file
 * @ingroup lpp
 * external API header
 */

/**
 * @defgroup lpp Libpostproc
 * @{
 */

// #include "libpostproc/version.h"

/**
 * Return the LIBPOSTPROC_VERSION_INT constant.
 */
public static native @Cast("unsigned") int postproc_version();

/**
 * Return the libpostproc build-time configuration.
 */
public static native @Cast("const char*") BytePointer postproc_configuration();

/**
 * Return the libpostproc license.
 */
public static native @Cast("const char*") BytePointer postproc_license();

public static final int PP_QUALITY_MAX = 6;

// #include <inttypes.h>

// #if LIBPOSTPROC_VERSION_INT < (52<<16)
// #else
/** a simple help text */
@MemberGetter public static native byte pp_help(int i);
@MemberGetter public static native @Cast("const char*") BytePointer pp_help();
// #endif

public static native void pp_postprocess(@Cast("const uint8_t**") PointerPointer src, @Const IntPointer srcStride,
                     @Cast("uint8_t**") PointerPointer dst, @Const IntPointer dstStride,
                     int horizontalSize, int verticalSize,
                     @Const BytePointer QP_store,  int QP_stride,
                     @Cast("pp_mode*") Pointer mode, @Cast("pp_context*") Pointer ppContext, int pict_type);
public static native void pp_postprocess(@Cast("const uint8_t**") @ByPtrPtr BytePointer src, @Const IntPointer srcStride,
                     @Cast("uint8_t**") @ByPtrPtr BytePointer dst, @Const IntPointer dstStride,
                     int horizontalSize, int verticalSize,
                     @Const BytePointer QP_store,  int QP_stride,
                     @Cast("pp_mode*") Pointer mode, @Cast("pp_context*") Pointer ppContext, int pict_type);
public static native void pp_postprocess(@Cast("const uint8_t**") @ByPtrPtr ByteBuffer src, @Const IntBuffer srcStride,
                     @Cast("uint8_t**") @ByPtrPtr ByteBuffer dst, @Const IntBuffer dstStride,
                     int horizontalSize, int verticalSize,
                     @Const BytePointer QP_store,  int QP_stride,
                     @Cast("pp_mode*") Pointer mode, @Cast("pp_context*") Pointer ppContext, int pict_type);
public static native void pp_postprocess(@Cast("const uint8_t**") @ByPtrPtr byte[] src, @Const int[] srcStride,
                     @Cast("uint8_t**") @ByPtrPtr byte[] dst, @Const int[] dstStride,
                     int horizontalSize, int verticalSize,
                     @Const BytePointer QP_store,  int QP_stride,
                     @Cast("pp_mode*") Pointer mode, @Cast("pp_context*") Pointer ppContext, int pict_type);


/**
 * Return a pp_mode or NULL if an error occurred.
 *
 * @param name    the string after "-pp" on the command line
 * @param quality a number from 0 to PP_QUALITY_MAX
 */
public static native @Cast("pp_mode*") Pointer pp_get_mode_by_name_and_quality(@Cast("const char*") BytePointer name, int quality);
public static native @Cast("pp_mode*") Pointer pp_get_mode_by_name_and_quality(String name, int quality);
public static native void pp_free_mode(@Cast("pp_mode*") Pointer mode);

public static native @Cast("pp_context*") Pointer pp_get_context(int width, int height, int flags);
public static native void pp_free_context(@Cast("pp_context*") Pointer ppContext);

public static final int PP_CPU_CAPS_MMX =   0x80000000;
public static final int PP_CPU_CAPS_MMX2 =  0x20000000;
public static final int PP_CPU_CAPS_3DNOW = 0x40000000;
public static final int PP_CPU_CAPS_ALTIVEC = 0x10000000;
public static final int PP_CPU_CAPS_AUTO =  0x00080000;

public static final int PP_FORMAT =         0x00000008;
public static final int PP_FORMAT_420 =    (0x00000011|PP_FORMAT);
public static final int PP_FORMAT_422 =    (0x00000001|PP_FORMAT);
public static final int PP_FORMAT_411 =    (0x00000002|PP_FORMAT);
public static final int PP_FORMAT_444 =    (0x00000000|PP_FORMAT);

/** MPEG2 style QScale */
public static final int PP_PICT_TYPE_QP2 =  0x00000010;

/**
 * @}
 */

// #endif /* POSTPROC_POSTPROCESS_H */


}
