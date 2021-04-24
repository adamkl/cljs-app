(ns cljs-app
  (:require [cljs-express :refer [express start stop]]))

(def routes [["/hello" :get (fn [ctx] (assoc ctx :response {:status 200
                                                            :body "Hello World"}))]])
(def server (atom nil))

(defn main []
  (reset! server (-> (express {:routes routes})
                     (start  3000 #(print "server started")))))

(comment
  (stop @server)
  (start @server 3000)
  (comment))