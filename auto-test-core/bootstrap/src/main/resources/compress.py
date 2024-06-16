import base64
import zlib
import sys

data = sys.argv[1]
compress_obj = zlib.compressobj(wbits=-15)
compressed_data = compress_obj.compress(data.encode('utf-8'))
compressed_data = compressed_data + compress_obj.flush()
compressed_encoded_data = base64.b64encode(compressed_data)
print(compressed_encoded_data.decode('utf-8'))
