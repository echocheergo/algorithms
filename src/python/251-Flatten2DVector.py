class Vector2D(object):

    def __init__(self, vec2d):
        """
        generator since only need once and vec could be huge
        """
        def get():
            for row in vec2d:
                for i in row:
                    yield i
        self.itr = get()
        self.cur = next(self.itr, None)

    def next(self):
        """
        :rtype: int
        """
        tmp = self.cur
        self.cur = next(self.itr, None)
        return tmp

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.cur != None