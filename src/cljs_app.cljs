(ns cljs-app
  (:require [cljs-express :refer [express start]]))

(def routes [["/hello" :get (fn [ctx] (assoc ctx :response {:status 200
                                                            :body "Hello World"}))]])
(def app (atom (express {:routes routes})))

(defn main []
  (start @app 3000 #(print "server started")))
