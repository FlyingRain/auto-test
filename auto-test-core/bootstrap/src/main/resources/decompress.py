import base64
import zlib
import sys


encoded_compressed_data = sys.argv[1]
compressed_data = base64.b64decode(encoded_compressed_data)
decompress_data = zlib.decompress(compressed_data, -zlib.MAX_WBITS)
decompress_str = decompress_data.decode('utf-8')
print(decompress_str)
