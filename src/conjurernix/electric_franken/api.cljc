(ns conjurernix.electric-franken.api
  "Macro based API inspired from electric ui4/ui5"
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [hyperfiddle.electric-ui4 :as ui4]
            [hyperfiddle.electric-ui5 :as ui5]
            [hashp.core]))

;; Macro-based API

(defmacro disabled []
  `(dom/props {:class "uk-disabled"}))

(defmacro separated []
  `(dom/props {:class "uk-separated"}))

(defmacro AccordionTitle [& body]
  `(dom/a (dom/props {:class "uk-accordion-title"
                      :href  ""})
     ~@body))

(defmacro AccordionIcon [& body]
  `(dom/span (dom/props {:class   "uk-accordion-icon"
                         :uk-icon "icon: chevron-down; ratio: 0.8"})
     ~@body))

(defmacro AccordionContent [& body]
  `(dom/div (dom/props {:class "uk-accordion-content"})
     ~@body))

(defmacro AccordionItem [& body]
  `(dom/li ~@body))

(defmacro Accordion [& body]
  `(dom/ul (dom/props {:uk-accordion ""
                       :class        "uk-accordion"})
     ~@body))

; TODO: Check if both collapsible and multiple can be used at the same time
(defmacro collapsible-accordion [bool]
  `(let [bool# ~bool]
     (dom/props {:uk-accordion (str "collapsible: " bool# ";")})))

(defmacro multiple-accordion [bool]
  `(let [bool# ~bool]
     (dom/props {:uk-accordion (str "multiple: " bool# ";")})))

(defmacro AlertTitle [& body]
  `(dom/div (dom/props {:class "uk-alert-title"})
     ~@body))

(defmacro AlertDescription [& body]
  `(dom/div (dom/props {:class "uk-alert-description"})
     ~@body))

(defmacro AlertClose [& body]
  `(dom/a (dom/props {:href "" :uk-close "" :class "uk-alert-close"})
     ~@body))

(defmacro Alert [& body]
  `(dom/div (dom/props {:uk-alert ""
                        :class    "uk-alert"})
     ~@body))

(defmacro alert-default []
  `(dom/props {:class "uk-alert-default"}))
(defmacro alert-primary []
  `(dom/props {:class "uk-alert-primary"}))
(defmacro alert-success []
  `(dom/props {:class "uk-alert-success"}))
(defmacro alert-warning []
  `(dom/props {:class "uk-alert-warning"}))
(defmacro alert-danger []
  `(dom/props {:class "uk-alert-danger"}))

(defmacro Badge [& body]
  `(dom/span (dom/props {:class "uk-badge"})
     ~@body))

(defmacro badge-primary []
  `(dom/props {:class "uk-badge-primary"}))
(defmacro badge-secondary []
  `(dom/props {:class "uk-badge-secondary"}))
(defmacro badge-danger []
  `(dom/props {:class "uk-badge-danger"}))

(defmacro Breadcrumb [& body]
  `(dom/ul (dom/props {:class "uk-breadcrumb"})
     ~@body))



(defmacro Button [& body]
  `(dom/button (dom/props {:class "uk-button" :type "button"})
     ~@body))

(defmacro ButtonLink [& body]
  `(dom/a (dom/props {:class "uk-button" :type "button"})
     ~@body))

(defmacro button-default []
  `(dom/props {:class "uk-button-default"}))
(defmacro button-ghost []
  `(dom/props {:class "uk-button-ghost"}))
(defmacro button-primary []
  `(dom/props {:class "uk-button-primary"}))
(defmacro button-secondary []
  `(dom/props {:class "uk-button-secondary"}))
(defmacro button-danger []
  `(dom/props {:class "uk-button-danger"}))
(defmacro button-text []
  `(dom/props {:class "uk-button-text"}))
(defmacro button-link []
  `(dom/props {:class "uk-button-link"}))

(defmacro CardFooter [& body]
  `(dom/div (dom/props {:class "uk-card-footer"})
     ~@body))

(defmacro CardBody [& body]
  `(dom/div (dom/props {:class "uk-card-body"})
     ~@body))

(defmacro CardTitle [& body]
  `(dom/h3 (dom/props {:class "uk-card-title"})
     ~@body))

(defmacro CardHeader [& body]
  `(dom/div (dom/props {:class "uk-card-header"})
     ~@body))

(defmacro CardBody [& body]
  `(dom/div (dom/props {:class "uk-card uk-card-body"})
     ~@body))

(defmacro Card [& body]
  `(dom/div (dom/props {:class "uk-card"})
     ~@body))

(defmacro card-default []
  `(dom/props {:class "uk-card-default"}))
(defmacro card-primary []
  `(dom/props {:class "uk-card-primary"}))
(defmacro card-secondary []
  `(dom/props {:class "uk-card-secondary"}))
(defmacro card-danger []
  `(dom/props {:class "uk-card-danger"}))

(defmacro CountdownSeconds [& body]
  `(dom/span (dom/props {:class "uk-countdown-number uk-countdown-seconds"})
     ~@body))

(defmacro CountdownMinutes [& body]
  `(dom/span (dom/props {:class "uk-countdown-number uk-countdown-minutes"})
     ~@body))

(defmacro CountdownHours [& body]
  `(dom/span (dom/props {:class "uk-countdown-number uk-countdown-hours"})
     ~@body))

(defmacro CountdownDays [& body]
  `(dom/span (dom/props {:class "uk-countdown-number uk-countdown-days"})
     ~@body))

(defmacro CountdownSeparator [& body]
  `(dom/span (dom/props {:class "uk-countdown-separator"})
     ~@body))

(defmacro Countdown [date & body]
  `(let [date# ~date]
     (dom/div (dom/props {:uk-countdown (str "date: " date#)})
       ~@body)))

(defmacro CoverVideo
  "Note: Here `body` is not used for new elements as `video` can't
   have children but for setting props etc."
  [& body]
  `(dom/video (dom/props {:uk-cover ""})
     ~@body))

(defmacro CoverImg
  "Note: Here `body` is not used for new elements as `img` can't
   have children but for setting props etc."
  [& body]
  `(dom/img (dom/props {:uk-cover ""})
     ~@body))

(defmacro CoverContainer [& body]
  `(dom/div (dom/props {:class "uk-cover-container"})
     ~@body))

(defmacro IconDivider [& body]
  `(dom/hr (dom/props {:class "uk-divider-icon"})
     ~@body))

(defmacro VerticalDivider [& body]
  `(dom/hr (dom/props {:class "uk-divider-vertical"})
     ~@body))

(defmacro SmallDivider
  "Note: need to add a height manually"
  [& body]
  `(dom/hr (dom/props {:class "uk-divider-vertical"})
     ~@body))

(defmacro NavDivider [& body]
  `(dom/li (dom/props {:class "uk-nav-divider"})
     ~@body))

(defmacro NavHeader [& body]
  `(dom/li (dom/props {:class "uk-nav-header"})
     ~@body))

(defmacro DotNav [& body]
  `(dom/ul (dom/props {:class "uk-dotnav"})
     ~@body))

(defmacro dotnav-vertical []
  `(dom/props {:class "uk-dotnav-vertical"}))

(defmacro drop-pos [pos]
  `(let [pos# (case ~pos
                :top-left "top-left"
                :top-center "top-center"
                :top-right "top-right"
                :bottom-left "bottom-left"
                :bottom-center "bottom-center"
                :bottom-right "bottom-right"
                :left-top "left-top"
                :left-center "left-center"
                :left-bottom "left-bottom"
                :right-top "right-top"
                :right-center "right-center"
                :right-bottom "right-bottom")]
     (dom/props {:uk-drop (str "pos: " pos# ";")})))

(defmacro drop-stretch [stretch]
  `(let [stretch# (case ~stretch
                    true "true"
                    :x "x"
                    :y "y")]
     (dom/props {:uk-drop (str "stretch: " stretch# ";")})))

(defmacro drop-mode [mode]
  `(let [mode# (case ~mode
                 :hover-click "click,hover"
                 :click "click"
                 :hover "hover")]
     (dom/props {:uk-drop (str "mode: " mode# ";")})))

(defmacro DropParentIcon [& body]
  `(dom/span (dom/props {:uk-drop-parent-icon "" :class "ml-2"})
     ~@body))

(defmacro Drop [& body]
  `(dom/div (dom/props {:uk-drop ""})
     ~@body))

(defmacro Dropbar [& body]
  `(dom/div (dom/props {:class "uk-dropbar" :uk-drop ""})
     ~@body))

(defmacro dropbar-direction [direction]
  `(let [style# (case ~direction
                  :top "uk-drop-bar-top"
                  :bottom "uk-drop-bar-bottom"
                  :left "uk-drop-bar-left"
                  :right "uk-drop-bar-right")]
     (dom/props {:class style#})))

(defmacro Inline [& body]
  `(dom/div (dom/props {:class "uk-inline"})
     ~@body))

(defmacro Nav [& body]
  `(dom/ul (dom/props {:class "uk-nav"})
     ~@body))

(defmacro DropdownNav [& body]
  `(dom/ul (dom/props {:class "uk-nav uk-dropdown-nav"})
     ~@body))

(defmacro Dropdown [& body]
  `(dom/div (dom/props {:class       "uk-dropdown"
                        :uk-dropdown ""})
     ~@body))

(defmacro Dropnav [& body]
  `(dom/nav (dom/props {:uk-drop-nav ""})
     ~@body))

(defmacro Subnav [& body]
  `(dom/ul (dom/props {:class "uk-subnav"})
     ~@body))

(defmacro FilterControl [selector & body]
  `(let [selector# ~selector]
     (dom/li (dom/props {:uk-filter-control selector#})
       ~@body)))

(defmacro Filter [selector & body]
  `(let [selector# ~selector]
     (dom/div (dom/props {:uk-filter selector#})
       ~@body)))

(defmacro Input [& body]
  `(dom/input (dom/props {:class "uk-input"})
     ~@body))

(defmacro Option [& body]
  `(dom/option ~@body))

(defmacro Select [& body]
  `(dom/select (dom/props {:class "uk-select"})
     ~@body))

(defmacro Textarea [& body]
  `(dom/textarea (dom/props {:class "uk-textarea"})
     ~@body))

(defmacro Radio [& body]
  `(dom/input (dom/props {:class "uk-radio" :type "radio"})
     ~@body))

(defmacro Checkbox [& body]
  `(dom/input (dom/props {:class "uk-checkbox"
                          :type  "checkbox"})
     ~@body))

(defmacro Range [& body]
  `(dom/input (dom/props {:class "uk-range"
                          :type  "range"})
     ~@body))

(defmacro ToggleSwitch [& body]
  `(dom/input (dom/props {:class "uk-toggle-switch"})
     ~@body))

(defmacro Label [& body]
  `(dom/label (dom/props {:class "uk-form-label"})
     ~@body))

(defmacro TagDelete [& body]
  `(dom/span (dom/props {:class    "uk-close"
                         :uk-close ""})
     ~@body))

(defmacro Tag [& body]
  `(dom/span (dom/props {:class "uk-tag"})
     ~@body))

(defmacro TagInput [& body]
  `(dom/div (dom/props {:class "uk-tag-input"})
     ~@body))

(defmacro PinInputBox [& body]
  `(dom/input (dom/props {:type "text" :maxlength "1"})
     ~@body))

(defmacro PinInput [& body]
  `(dom/div (dom/props {:class "uk-pin-input"})
     ~@body))

(defmacro FormHelp [& body]
  `(dom/div (dom/props {:class "uk-form-help"})
     ~@body))

(defmacro Fieldset [& body]
  `(dom/fieldset (dom/props {:class "uk-fieldset"})
     ~@body))

(defmacro form-stacked []
  `(dom/props {:class "uk-form-stacked"}))
(defmacro form-horizontal []
  `(dom/props {:class "uk-form-horizontal"}))

(defmacro FormControls [& body]
  `(dom/div (dom/props {:class "uk-form-controls"})
     ~@body))

(defmacro FormIconLink [icon & body]
  `(dom/a (dom/props {:class   "uk-form-icon"
                      :uk-icon (str "icon: " (name icon))})))

(defmacro FormIcon [icon & body]
  `(dom/span (dom/props {:class   "uk-form-icon"
                         :uk-icon (str "icon: " (name icon))})))

(defmacro FormCustom [& body]
  `(dom/div (dom/props {:class "uk-form-custom"})
     ~@body))