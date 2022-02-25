/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.media.jfxmedia;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public enum MediaError {

    ERROR_BASE_MEDIA(0x00000100),
    ERROR_BASE_MANAGER(0x00000200),
    ERROR_BASE_PIPELINE(0x00000300),
    ERROR_BASE_FACTORY(0x00000400),
    ERROR_BASE_LOCATOR(0x00000500),
    ERROR_BASE_REGISTRY(0x00000600),
    ERROR_BASE_GSTREAMER(0x00000800),
    ERROR_BASE_SYSTEM(0x00000A00),
    ERROR_BASE_FUNCTION(0x00000B00),
    ERROR_BASE_JNI(0x00000C00),       // JNI upcall from native into Java
    ERROR_BASE_OSX(0x00000D00),

    WARNING_BASE_JFXMEDIA(0x00100000),
    WARNING_BASE_GSTREAMER(0x00800000),
    WARNING_BASE_GLIB(0x00900000),

    ERROR_MASK_BASE(0x00000F00),
    WARNING_MASK_BASE(0x00F00000),

    ERROR_NONE(0x0),

    ERROR_MANAGER_NULL(ERROR_BASE_MANAGER.code()+0x0001),
    ERROR_MANAGER_CREATION(ERROR_BASE_MANAGER.code()+0x0002),
    ERROR_MANAGER_ENGINEINIT_FAIL(ERROR_BASE_MANAGER.code()+0x0003),
    ERROR_MANAGER_RUNLOOP_FAIL(ERROR_BASE_MANAGER.code()+0x0004),
    ERROR_MANAGER_LOGGER_INIT(ERROR_BASE_MANAGER.code()+0x0005),

    ERROR_MEDIA_NULL(ERROR_BASE_MEDIA.code()+0x0001),
    ERROR_MEDIA_CREATION(ERROR_BASE_MEDIA.code()+0x0002),
    ERROR_MEDIA_UNKNOWN_PIXEL_FORMAT(ERROR_BASE_MEDIA.code()+0x0003),
    ERROR_MEDIA_INVALID(ERROR_BASE_MEDIA.code()+0x0004),
    ERROR_MEDIA_MARKER_NAME_NULL(ERROR_BASE_MEDIA.code()+0x0005),
    ERROR_MEDIA_MARKER_TIME_NEGATIVE(ERROR_BASE_MEDIA.code()+0x0006),
    ERROR_MEDIA_MARKER_MAP_NULL(ERROR_BASE_MEDIA.code()+0x0007),
    ERROR_MEDIA_VIDEO_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x0008),
    ERROR_MEDIA_AUDIO_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x0009),
    ERROR_MEDIA_MP3_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x000A),
    ERROR_MEDIA_AAC_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x000B),
    ERROR_MEDIA_H264_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x000C),
    ERROR_MEDIA_HLS_FORMAT_UNSUPPORTED(ERROR_BASE_MEDIA.code()+0x000D),
    ERROR_MEDIA_CORRUPTED(ERROR_BASE_MEDIA.code()+0x000E),

    ERROR_PIPELINE_NULL(ERROR_BASE_PIPELINE.code()+0x0001),
    ERROR_PIPELINE_CREATION(ERROR_BASE_PIPELINE.code()+0x0002),
    ERROR_PIPELINE_NO_FRAME_QUEUE(ERROR_BASE_PIPELINE.code()+0x0003),

    ERROR_FACTORY_NULL(ERROR_BASE_FACTORY.code()+0x0001),
    ERROR_FACTORY_CONTAINER_CREATION(ERROR_BASE_FACTORY.code()+0x0002),
    ERROR_FACTORY_INVALID_URI(ERROR_BASE_FACTORY.code()+0x0003),

    ERROR_LOCATOR_NULL(ERROR_BASE_LOCATOR.code()+0x0001),
    ERROR_LOCATOR_UNSUPPORTED_TYPE(ERROR_BASE_LOCATOR.code()+0x0002),
    ERROR_LOCATOR_UNSUPPORTED_MEDIA_FORMAT(ERROR_BASE_LOCATOR.code()+0x0003),
    ERROR_LOCATOR_CONNECTION_LOST(ERROR_BASE_LOCATOR.code()+0x0004),
    ERROR_LOCATOR_CONTENT_TYPE_NULL(ERROR_BASE_LOCATOR.code()+0x0005),

    ERROR_REGISTRY_NULL(ERROR_BASE_REGISTRY.code()+0x0001),
    ERROR_REGISTRY_PLUGIN_ALREADY_EXIST(ERROR_BASE_REGISTRY.code()+0x0002),
    ERROR_REGISTRY_PLUGIN_PATH(ERROR_BASE_REGISTRY.code()+0x0003),
    ERROR_REGISTRY_NO_MATCHING_RECIPE(ERROR_BASE_REGISTRY.code()+0x0004),

    ERROR_GSTREAMER_ERROR(ERROR_BASE_GSTREAMER.code()+0x0001),
    ERROR_GSTREAMER_PIPELINE_CREATION(ERROR_BASE_GSTREAMER.code()+0x0002),
    ERROR_GSTREAMER_AUDIO_DECODER_SINK_PAD(ERROR_BASE_GSTREAMER.code()+0x0003),
    ERROR_GSTREAMER_AUDIO_DECODER_SRC_PAD(ERROR_BASE_GSTREAMER.code()+0x0004),
    ERROR_GSTREAMER_AUDIO_SINK_SINK_PAD(ERROR_BASE_GSTREAMER.code()+0x0005),
    ERROR_GSTREAMER_VIDEO_DECODER_SINK_PAD(ERROR_BASE_GSTREAMER.code()+0x0006),
    ERROR_GSTREAMER_PIPELINE_STATE_CHANGE(ERROR_BASE_GSTREAMER.code()+0x0007),
    ERROR_GSTREAMER_PIPELINE_SEEK(ERROR_BASE_GSTREAMER.code()+0x0008),
    ERROR_GSTREAMER_PIPELINE_QUERY_LENGTH(ERROR_BASE_GSTREAMER.code()+0x0009),
    ERROR_GSTREAMER_PIPELINE_QUERY_POS(ERROR_BASE_GSTREAMER.code()+0x000A),
    ERROR_GSTREAMER_PIPELINE_METADATA_TYPE(ERROR_BASE_GSTREAMER.code()+0x000B),
    ERROR_GSTREAMER_AUDIO_SINK_CREATE(ERROR_BASE_GSTREAMER.code()+0x000C),
    ERROR_GSTREAMER_GET_BUFFER_SRC_PAD(ERROR_BASE_GSTREAMER.code()+0x000D),
    ERROR_GSTREAMER_CREATE_GHOST_PAD(ERROR_BASE_GSTREAMER.code()+0x000E),
    ERROR_GSTREAMER_ELEMENT_ADD_PAD(ERROR_BASE_GSTREAMER.code()+0x000F),
    ERROR_GSTREAMER_UNSUPPORTED_PROTOCOL(ERROR_BASE_GSTREAMER.code()+0x0010),
    ERROR_GSTREAMER_SOURCEFILE_NONEXISTENT(ERROR_BASE_GSTREAMER.code()+0x0020),
    ERROR_GSTREAMER_SOURCEFILE_NONREGULAR(ERROR_BASE_GSTREAMER.code()+0x0030),
    ERROR_GSTREAMER_ELEMENT_LINK(ERROR_BASE_GSTREAMER.code()+0x0040),
    ERROR_GSTREAMER_ELEMENT_LINK_AUDIO_BIN(ERROR_BASE_GSTREAMER.code()+0x0050),
    ERROR_GSTREAMER_ELEMENT_LINK_VIDEO_BIN(ERROR_BASE_GSTREAMER.code()+0x0060),
    ERROR_GSTREAMER_ELEMENT_CREATE(ERROR_BASE_GSTREAMER.code()+0x0070),
    ERROR_GSTREAMER_VIDEO_SINK_CREATE(ERROR_BASE_GSTREAMER.code()+0x0080),
    ERROR_GSTREAMER_BIN_CREATE(ERROR_BASE_GSTREAMER.code()+0x0090),
    ERROR_GSTREAMER_BIN_ADD_ELEMENT(ERROR_BASE_GSTREAMER.code()+0x00A0),
    ERROR_GSTREAMER_ELEMENT_GET_PAD(ERROR_BASE_GSTREAMER.code()+0x00B0),
    ERROR_GSTREAMER_MAIN_LOOP_CREATE(ERROR_BASE_GSTREAMER.code()+0x00C0),
    ERROR_GSTREAMER_BUS_SOURCE_ATTACH(ERROR_BASE_GSTREAMER.code()+0x00C1),
    ERROR_GSTREAMER_PIPELINE_SET_RATE_ZERO(ERROR_BASE_GSTREAMER.code()+0x00D0),
    ERROR_GSTREAMER_VIDEO_SINK_SINK_PAD(ERROR_BASE_GSTREAMER.code()+0x00E0),

    ERROR_NOT_IMPLEMENTED(ERROR_BASE_SYSTEM.code()+0x0001),
    ERROR_MEMORY_ALLOCATION(ERROR_BASE_SYSTEM.code()+0x0002),
    ERROR_OS_UNSUPPORTED(ERROR_BASE_SYSTEM.code()+0x0003),
    ERROR_PLATFORM_UNSUPPORTED(ERROR_BASE_SYSTEM.code()+0x0004),

    ERROR_FUNCTION_PARAM(ERROR_BASE_FUNCTION.code()+0x0001),
    ERROR_FUNCTION_PARAM_NULL(ERROR_BASE_FUNCTION.code()+0x0002),

    ERROR_JNI_SEND_PLAYER_MEDIA_ERROR_EVENT(ERROR_BASE_JNI.code()+0x0001),
    ERROR_JNI_SEND_PLAYER_HALT_EVENT(ERROR_BASE_JNI.code()+0x0002),
    ERROR_JNI_SEND_PLAYER_STATE_EVENT(ERROR_BASE_JNI.code()+0x0003),
    ERROR_JNI_SEND_NEW_FRAME_EVENT(ERROR_BASE_JNI.code()+0x0004),
    ERROR_JNI_SEND_FRAME_SIZE_CHANGED_EVENT(ERROR_BASE_JNI.code()+0x0005),
    ERROR_JNI_SEND_END_OF_MEDIA_EVENT(ERROR_BASE_JNI.code()+0x0006),
    ERROR_JNI_SEND_AUDIO_TRACK_EVENT(ERROR_BASE_JNI.code()+0x0007),
    ERROR_JNI_SEND_VIDEO_TRACK_EVENT(ERROR_BASE_JNI.code()+0x0008),
    ERROR_JNI_SEND_METADATA_EVENT(ERROR_BASE_JNI.code()+0x0009),
    ERROR_JNI_SEND_MARKER_EVENT(ERROR_BASE_JNI.code()+0x000A),
    ERROR_JNI_SEND_BUFFER_PROGRESS_EVENT(ERROR_BASE_JNI.code()+0x000B),
    ERROR_JNI_SEND_STOP_REACHED_EVENT(ERROR_BASE_JNI.code()+0x000C),
    ERROR_JNI_SEND_DURATION_UPDATE_EVENT(ERROR_BASE_JNI.code()+0x000D),
    ERROR_JNI_SEND_AUDIO_SPECTRUM_EVENT(ERROR_BASE_JNI.code()+0x000E),

    ERROR_OSX_INIT(ERROR_BASE_OSX.code() + 0x0001),

    WARNING_JFXMEDIA_BALANCE(WARNING_BASE_JFXMEDIA.code() + 0x0001),

    WARNING_GSTREAMER_WARNING(WARNING_BASE_GSTREAMER.code()+0x0001),
    WARNING_GSTREAMER_PIPELINE_ERROR(WARNING_BASE_GSTREAMER.code()+0x0002),
    WARNING_GSTREAMER_PIPELINE_WARNING(WARNING_BASE_GSTREAMER.code()+0x0003),
    WARNING_GSTREAMER_PIPELINE_STATE_EVENT(WARNING_BASE_GSTREAMER.code()+0x0004),
    WARNING_GSTREAMER_PIPELINE_FRAME_SIZE(WARNING_BASE_GSTREAMER.code()+0x0005),
    WARNING_GSTREAMER_INVALID_FRAME(WARNING_BASE_GSTREAMER.code()+0x0006),
    WARNING_GSTREAMER_PIPELINE_INFO_ERROR(WARNING_BASE_GSTREAMER.code()+0x0007),
    WARNING_GSTREAMER_AUDIO_BUFFER_FIELD(WARNING_BASE_GSTREAMER.code()+0x0008);

    private static ResourceBundle bundle;
    private static final Map<Integer, MediaError> map = new HashMap<Integer, MediaError>();

    static {
        try {
            bundle = ResourceBundle.getBundle("MediaErrors", Locale.getDefault());
        } catch(MissingResourceException e) {
            bundle = null;
        }

        for (MediaError error : MediaError.values()) {
            map.put(error.code(), error);
        }
    }

    private int    code;
    private String description;

    private MediaError(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public String description() {
        if (description == null) {
            String errorName = name();
            if (bundle != null) {
                try {
                    description = bundle.getString(errorName);
                } catch (MissingResourceException e) {
                    description = errorName;
                }
            } else {
                description = errorName;
            }
        }
        return description;
    }

    public static MediaError getFromCode(int code) {
        return map.get(code);
    }
}
