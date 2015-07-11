(ns cassandra.lwt-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer [pprint]]
            [cassandra.lwt :refer :all]
            [cassandra.core-test :refer :all]
            [jepsen [core :as jepsen]
             [report :as report]]))

;; Steady state cluster tests
(deftest ^:lwt ^:steady lwt-bridge
  (run-cas-register-test! bridge-test timestamp))

(deftest ^:lwt ^:steady lwt-isolate-node
  (run-cas-register-test! isolate-node-test timestamp))

(deftest ^:lwt ^:steady lwt-halves
  (run-cas-register-test! halves-test timestamp))

(deftest ^:lwt ^:steady lwt-crash-subset
  (run-cas-register-test! crash-subset-test timestamp))

(deftest ^:clock lwt-clock-drift
  (run-cas-register-test! clock-drift-test timestamp))

;; Bootstrapping tests
(deftest ^:lwt ^:bootstrap lwt-bridge-bootstrap
  (run-cas-register-test! bridge-test-bootstrap timestamp))

(deftest ^:lwt ^:bootstrap lwt-isolate-node-bootstrap
  (run-cas-register-test! isolate-node-test-bootstrap timestamp))

(deftest ^:lwt ^:bootstrap lwt-halves-bootstrap
  (run-cas-register-test! halves-test-bootstrap timestamp))

(deftest ^:lwt ^:bootstrap lwt-crash-subset-bootstrap
  (run-cas-register-test! crash-subset-test-bootstrap timestamp))

(deftest ^:clock lwt-clock-drift-bootstrap
  (run-cas-register-test! clock-drift-test-bootstrap timestamp))

;; Decommission tests
(deftest ^:lwt ^:decommission lwt-bridge-decommission
  (run-cas-register-test! bridge-test-decommission timestamp))

(deftest ^:lwt ^:decommission lwt-isolate-node-decommission
  (run-cas-register-test! isolate-node-test-decommission timestamp))

(deftest ^:lwt ^:decommission lwt-halves-decommission
  (run-cas-register-test! halves-test-decommission timestamp))

(deftest ^:lwt ^:decommission lwt-crash-subset-decommission
  (run-cas-register-test! crash-subset-test-decommission timestamp))

(deftest ^:clock lwt-clock-drift-decommission
  (run-cas-register-test! clock-drift-test-decommission timestamp))
