# !/usr/bin/env python
# -*- coding:utf-8 -*-

from gevent.coros import RLock
from bottle import route, Bottle, run

lock = RLock()

class Counter(object):
    counts = {}
    def get(self, app, id):
        key = '_'.join((app, id))
        count = self.counts.get(key, 0)
        return {'data' : count}
    
    def inc(self, app, id, step):
        key = '_'.join((app, id))
        count = self.counts.get(key, 0)
        if lock.acquire(0) is False:
            return {'data' : count}
        try:
            count += 1
            self.counts[key] = count
        finally:
            lock.release()
        
    def delete(self, app, id):
        key = '_'.join((app, id))
        if lock.acquire(0) is False:
            return -1
        try:
            return self.counts.pop(key)
        except:
            return -1
        finally:
            lock.release()

counter = Counter()
demo = Bottle() 

def get_app():
    return demo           

@demo.get("/api/<app>/<id>/")            
def do_get(app, id):
    return counter.get(app, id)

@demo.post("/api/<app>/<id>/")           
def do_get(app, id):
    return counter.inc(app, id, 1)  

@demo.delete("/api/<app>/<id>/")          
def do_get(app, id):
    result = counter.delete()
    if result <= 0:
        return False
    return True


if __name__ == '__main__':
    run(server='gevent', host='192.168.0.131', port=8102, app=demo) 
    