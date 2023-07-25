package io.curiositycore.curiousclasses.utils;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Used to do any binary related functionalities within the plugin. This includes conversion to binary, binary translation
 * and manipulation of binary data.
 */
public class BinaryUtil {
    /**
     * Converts a UUID into binary format, for the sake of storing within a SQL database for memory efficiency.
     * @param uuid The UUID to convert to binary.
     * @return A byte array of the UUID in terms of binary.
     */
    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }
}
