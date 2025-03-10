// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Infineon Technologies AG
// SPDX-License-Identifier: MIT

package com.infineon.css.nbt_passthrough_demonstrator.usecase_passthrough.utils;


/**
 * Stores basic constants for the NBT product line
 */
@SuppressWarnings("unused")
public class NbtConstants {

    /**
     * Global variable for CC file ID
     */
    static public final short NBT_ID_CC_FILE = (short)57603;

    /**
     * Global variable for NDEF file ID
     */
    static public final short NBT_ID_NDEF_FILE = (short)57604;

    /**
     * Global variable for FAP file ID
     */
    static public final short NBT_ID_FAP_FILE = (short)57775;

    /**
     * Global variable for proprietary file1 ID
     */
    static public final short NBT_ID_PP1_FILE = (short)57761;

    /**
     * Global variable for proprietary file2 ID
     */
    static public final short NBT_ID_PP2_FILE = (short)57762;

    /**
     * Global variable for proprietary file3 ID
     */
    static public final short NBT_ID_PP3_FILE = (short)57763;

    /**
     * Global variable for proprietary file4 ID
     */
    static public final short NBT_ID_PP4_FILE = (short)57764;

    /**
     * Global variable for the default offset
     */
    static public final short DEFAULT_OFFSET = (short) 0;

    /**
     * Global variable for the default apdu frame size
     */
    static public short APDU_FRAME_SIZE = (short) 255;
}
