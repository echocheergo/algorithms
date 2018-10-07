from math import acos, sin, cos, radians
RADIUS_MILES = 3963
class DestinationCal:
    loc = {}
    def process(self, line):
        l = line.split(':')
        if l[0] == 'LOC':
            self.loc[l[1]] = (radians(float(l[2])), radians(float(l[3])))
            return l[1]
        else:

            a = acos(sin(self.loc[l[2]][0])*sin(self.loc[l[3]][0]) + \
            cos(self.loc[l[2]][0])*cos(self.loc[l[3]][0])*cos(abs(self.loc[l[2]][1]-self.loc[l[3]][1])))
            d = RADIUS_MILES * a
            print(a)
            return line[5:]+':{}'.format(d)

res = DestinationCal()
print(res.process('LOC:CHI:41.836944:-87.684722'))   
print(res.process('LOC:NYC:40.7127:-74.0059'))   
print(res.process('TRIP:C0FFEE1C:CHI:NYC'))   