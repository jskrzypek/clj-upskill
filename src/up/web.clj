(ns up.web
  (:require [mount.core :refer [defstate]]
            [ring.adapter.undertow :as ut]))

(defn handler
  [_]
  {:status 200
   :body "Success!"})

(defstate server
  :start (ut/run-undertow handler {:port 8181})
  :stop  (.stop server))

(comment
  (ut/run-undertow handler {:port 8181})
  (mount.core/start server)
  (mount.core/stop server) 
  )