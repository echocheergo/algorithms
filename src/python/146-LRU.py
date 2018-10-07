import collections
class LRUCache:

    def __init__(self, capacity):
        self.od = collections.OrderedDict()
        self.size = capacity

    def get(self, key):
        if key in self.od:
            self.od.move_to_end(key)
            return self.od[key]
        else:
            return -1
    def put(self, key, value):
        if key in self.od:
            del self.od[key]
        while len(self.od) >= self.size:
            self.od.popitem(last = False)
        self.od[key] = value
