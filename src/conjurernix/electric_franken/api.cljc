(ns conjurernix.electric-franken.api
  "Macro based API inspired from electric ui4/ui5"
  (:refer-clojure :exclude [drop])
  (:require [hyperfiddle.electric-dom2 :as dom]))

;; Macro-based API

(defmacro disabled []
  `(dom/props {:class "uk-disabled"}))

(defmacro separated []
  `(dom/props {:class "uk-separated"}))

(defmacro open []
  `(dom/props {:class "uk-open"}))


(defmacro active []
  `(dom/props {:class "uk-active"}))

(defmacro target [selector]
  `(dom/props {:target ~selector}))

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

; TODO: This pattern is very common, should be abstracted into a macro.
(defmacro accordion [opts]
  `(let [opts# ~opts
         multiple# (get opts# :multiple)
         collapsible# (get opts# :collapsible)]
     (dom/props {:uk-accordion (cond-> ""
                                 (some? multiple#) (str "multiple: " multiple# ";")
                                 (some? collapsible#) (str "collapsible: " collapsible# ";"))})))

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

(defmacro BreadcrumbItem [& body]
  `(dom/li ~@body))

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
  `(dom/div (dom/props {:class "uk-card-body"})
     ~@body))

(defmacro Card [& body]
  `(dom/div (dom/props {:class "uk-card"})
     ~@body))

(defmacro card-body []
  `(dom/props {:class "uk-card-body"}))

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

(defmacro Countdown [& body]
  `(dom/div (dom/props {:uk-countdown ""})
     ~@body))

(defmacro countdown-date [date]
  `(dom/props {:uk-countdown (str "date: " ~date)}))

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
  `(dom/hr (dom/props {:class "uk-divider-small"})
     ~@body))

(defmacro nav-header []
  `(dom/props {:class "uk-nav-header"}))
(defmacro nav-divider []
  `(dom/props {:class "uk-nav-divider"}))

(defmacro NavItem [& body]
  `(dom/li ~@body))

(defmacro NavDivider [& body]
  `(NavItem (nav-divider)
     ~@body))

(defmacro NavHeader [& body]
  `(NavItem (nav-header)
     ~@body))

(defmacro nav-item-active []
  `(active))

(defmacro DotNav [& body]
  `(dom/ul (dom/props {:class "uk-dotnav"})
     ~@body))

(defmacro dotnav-vertical []
  `(dom/props {:class "uk-dotnav-vertical"}))


(defmacro drop [opts]
  `(let [opts# ~opts
         pos# (get opts# :pos)
         stretch# (get opts# :stretch)
         mode# (get opts# :mode)]
     (dom/props {:uk-drop (cond-> ""
                            (some? pos#) (str "pos: " pos# ";")
                            (some? mode#) (str "mode: " mode# ";")
                            (some? stretch#) (str "stretch: " stretch# ";"))})))

(defmacro DropParentIcon [& body]
  `(dom/span (dom/props {:uk-drop-parent-icon ""})
     ~@body))

(defmacro Drop [& body]
  `(dom/div (dom/props {:uk-drop ""})
     ~@body))

(defmacro dropbar-top []
  `(dom/props {:class "uk-dropbar-top"}))
(defmacro dropbar-bottom []
  `(dom/props {:class "uk-dropbar-bottom"}))
(defmacro dropbar-left []
  `(dom/props {:class "uk-dropbar-left"}))
(defmacro dropbar-right []
  `(dom/props {:class "uk-dropbar-right"}))


(defmacro Dropbar [& body]
  `(dom/div (dom/props {:class "uk-dropbar" :uk-drop ""})
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
  `(dom/nav (dom/props {:uk-dropnav ""})
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
  `(dom/input (dom/props {:class "uk-toggle-switch"
                          :type  "checkbox"})
     ~@body))

(defmacro toggle-switch-primary []
  `(dom/props {:class "uk-toggle-switch-primary"}))

(defmacro toggle-switch-danger []
  `(dom/props {:class "uk-toggle-switch-danger"}))


(defmacro FormLabel [& body]
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
                      :uk-icon (str "icon: " (name ~icon))})))

(defmacro FormIcon [icon & body]
  `(dom/span (dom/props {:class   "uk-form-icon"
                         :uk-icon (str "icon: " (name ~icon))})))

(defmacro FormCustom [& body]
  `(dom/div (dom/props {:class "uk-form-custom"})
     ~@body))

(defmacro form-danger []
  `(dom/props {:class "uk-form-danger"}))

(defmacro form-width-medium []
  `(dom/props {:class "uk-form-width-medium"}))

(defmacro form-disabled []
  `(dom/props {:disabled true}))

(defmacro Legend [& body]
  `(dom/legend (dom/props {:class "uk-legend"})
     ~@body))

(defmacro grid [opts]
  `(dom/props {:uk-grid ""}))

(defmacro grid-small []
  `(dom/props {:class "uk-grid-small"}))
(defmacro grid-medium []
  `(dom/props {:class "uk-grid-medium"}))
(defmacro grid-large []
  `(dom/props {:class "uk-grid-large"}))
(defmacro grid-collapse []
  `(dom/props {:class "uk-grid-collapse"}))

(defmacro grid-column-small []
  `(dom/props {:class "uk-grid-column-small"}))
(defmacro grid-row-small []
  `(dom/props {:class "uk-grid-row-small"}))
(defmacro grid-column-medium []
  `(dom/props {:class "uk-grid-column-medium"}))
(defmacro grid-row-medium []
  `(dom/props {:class "uk-grid-row-medium"}))
(defmacro grid-column-large []
  `(dom/props {:class "uk-grid-column-large"}))
(defmacro grid-row-large []
  `(dom/props {:class "uk-grid-row-large"}))
(defmacro grid-column-collapse []
  `(dom/props {:class "uk-grid-column-collapse"}))
(defmacro grid-row-collapse []
  `(dom/props {:class "uk-grid-row-collapse"}))

(defmacro Grid [& body]
  `(dom/div (grid {})
     ~@body))

(defmacro Icon [icon & body]
  `(dom/span (dom/props {:uk-icon (str "icon: " (name ~icon))})
     ~@body))


(defmacro IconLink [icon & body]
  `(dom/a (dom/props {:uk-icon (str "icon: " (name ~icon))})
     ~@body))

(defmacro icon-link []
  `(dom/props {:class "uk-icon-link"}))

(defmacro icon-button []
  `(dom/props {:class "uk-icon-button"}))

(defmacro icon-image [url]
  `(dom/props {:class "uk-icon-image"
               :style (str "background-image: url(" ~url ");")}))

(defmacro Iconnav [& body]
  `(dom/ul (dom/props {:class "uk-iconnav"})
     ~@body))

(defmacro iconnav-vertical []
  `(dom/props {:class "uk-iconnav-vertical"}))

(defmacro iconnav-outline []
  `(dom/props {:class "uk-iconnav-outline"}))

(defmacro Label [& body]
  `(dom/span (dom/props {:class "uk-label"})
     ~@body))

(defmacro label-primary []
  `(dom/props {:class "uk-label-primary"}))

(defmacro label-secondary []
  `(dom/props {:class "uk-label-secondary"}))

(defmacro label-success []
  `(dom/props {:class "uk-label-success"}))

(defmacro label-danger []
  `(dom/props {:class "uk-label-danger"}))

(defmacro leader [opts]
  `(let [opts# ~opts
         fill# (get opts# :fill)
         media# (get opts# :media)]
     (dom/props {:uk-leader (cond-> ""
                              (some? fill#) (str "fill: " fill# ";")
                              (some? media#) (str "media: " media# ";"))})))

(defmacro Leader [& body]
  `(dom/div (leader {})
     ~@body))

(defmacro Lightbox [& body]
  `(dom/div (dom/props {:uk-lightbox ""})
     ~@body))

; TODO: Implement lightbox
; TODO: Add `data-alt`, `data-caption` and data-type helpers

(defmacro Modal [& body]
  `(dom/div (dom/props {:class "uk-modal" :uk-modal ""})
     ~@body))

(defmacro ModalDialog [& body]
  `(dom/div (dom/props {:class "uk-modal-dialog uk-modal-body"})
     ~@body))

(defmacro ModalTitle [& body]
  `(dom/h2 (dom/props {:class "uk-modal-title"})
     ~@body))

(defmacro modal-title []
  `(dom/props {:class "uk-modal-title"}))

(defmacro modal-body []
  `(dom/props {:class "uk-modal-body"}))

(defmacro ModalClose [& body]
  `(dom/button (dom/props {:class    "uk-modal-close-default"
                           :type     "button"
                           :uk-close ""})
     ~@body))

(defmacro ModalCloseOutside [& body]
  `(dom/button (dom/props {:class    "uk-modal-close-outside"
                           :type     "button"
                           :uk-close ""})
     ~@body))

(defmacro margin-auto-vertical []
  `(dom/props {:class "uk-margin-auto-vertical"}))

(defmacro ModalHeader [& body]
  `(dom/div (dom/props {:class "uk-modal-header"})
     ~@body))

(defmacro ModalBody [& body]
  `(dom/div (dom/props {:class "uk-modal-body"})
     ~@body))

(defmacro ModalFooter [& body]
  `(dom/div (dom/props {:class "uk-modal-footer"})
     ~@body))

(defmacro Nav [& body]
  `(dom/div (dom/props {:class "uk-nav"})
     ~@body))

(defmacro nav
  "By default, child menu items are always visible. To apply an accordion effect,
   just add the uk-nav attribute to the main <ul>.
   When clicking on a parent item, an open one will close, allowing only one open nested list at a time.
   To allow multiple open subnavs, just add the multiple: true option to the attribute."
  [opts]
  `(let [opts# ~opts
         multiple# (get opts# :multiple)]
     (dom/props {:uk-nav (cond-> ""
                           (some? multiple#)
                           (str "multiple: " multiple# ";"))})))

(defmacro nav-default []
  `(dom/props {:class "uk-nav-default"}))
(defmacro nav-primary []
  `(dom/props {:class "uk-nav-primary"}))
(defmacro nav-secondary []
  `(dom/props {:class "uk-nav-secondary"}))

(defmacro parent []
  `(dom/props {:class "uk-parent"}))

(defmacro NavParentItem [& body]
  `(NavItem (parent) ~@body))

(defmacro NavSub [& body]
  `(dom/ul (dom/props {:class "uk-nav-sub"})
     ~@body))

(defmacro NavParentIcon [& body]
  `(dom/span (dom/props {:uk-nav-parent-icon ""})
     ~@body))

(defmacro NavSubtitle [& body]
  `(dom/div (dom/props {:class "uk-nav-subtitle"})
     ~@body))

; TODO: Support the rest of the opts (stretch, boundary, flip)
(defmacro navbar [opts]
  `(let [opts# ~opts
         mode# (get opts# :mode)
         align# (get opts# :align)
         target# (get opts# :target)
         dropbar# (get opts# :dropbar)]
     `(dom/props {:uk-navbar (cond-> ""
                               (some? mode#) (str "mode: " mode# ";")
                               (some? align#) (str "align: " align# ";")
                               (some? target#) (str "target: " target# ";")
                               (some? dropbar#) (str "dropbar: " dropbar# ";"))})))

(defmacro Navbar [& body]
  `(dom/nav (navbar {})
     ~@body))

(defmacro navbar-container []
  `(dom/props {:class "uk-navbar-container"}))

(defmacro NavbarContainer [& body]
  `(Navbar (navbar-container) ~@body))

(defmacro navbar-left []
  `(dom/props {:class "uk-navbar-left"}))
(defmacro navbar-right []
  `(dom/props {:class "uk-navbar-right"}))
(defmacro navbar-center []
  `(dom/props {:class "uk-navbar-center"}))


(defmacro NavbarLeft [& body]
  `(dom/div (navbar-left)
     ~@body))

(defmacro NavbarRight [& body]
  `(dom/div (navbar-right)
     ~@body))

(defmacro NavbarCenter [& body]
  `(dom/div (navbar-center)
     ~@body))

(defmacro NavbarNav [& body]
  `(dom/ul (dom/props {:class "uk-navbar-nav"})
     ~@body))

(defmacro Container [& body]
  `(dom/div (dom/props {:class "uk-container"})
     ~@body))

(defmacro navbar-transparent []
  `(dom/props {:class "uk-navbar-transparent"}))

(defmacro navbar-item []
  `(dom/props {:class "uk-navbar-item"}))

(defmacro NavbarItem [& body]
  `(dom/div (navbar-item) ~@body))

(defmacro NavbarToggle [& body]
  `(dom/a (dom/props {:class "uk-navbar-toggle " :uk-navbar-toggle-icon ""})
     ~@body))

(defmacro navbar-toggle-animate []
  `(dom/props {:class "uk-navbar-toggle-animate"}))

(defmacro NavbarDropdown [& body]
  `(dom/div (dom/props {:class "uk-navbar-dropdown"})
     ~@body))

(defmacro NavbarDropdownNav [& body]
  `(Nav (dom/props {:class "uk-navbar-dropdown-nav"}) ~@body))

(defmacro navbar-dropdown-width [w]
  `(dom/props {:class (str "uk-navbar-dropdown-width-" w)}))

(defmacro NavbarSticky [& body]
  `(dom/div (dom/props {:uk-sticky "sel-target: .uk-navbar-container; cls-active: uk-navbar-sticky"})
     ~@body))

(defmacro notification [opts]
  `(js/UIkit.notification (clj->js ~opts)))

(defmacro notification-close [notification immediate]
  `(.close ~notification ~immediate))

(defmacro notification-close-all []
  `(js/UIkit.notification.closeAll))

(defmacro offcanvas [opts]
  `(let [opts# ~opts
         overlay# (get opts# :overlay)
         flip# (get opts# :flip)
         mode# (get opts# :mode)]
     (dom/props {:uk-offcanvas (cond-> ""
                                 (some? overlay#) (str "overlay: " overlay# ";")
                                 (some? flip#) (str "flip: " flip# ";")
                                 (some? mode#) (str "mode: " mode# ";"))})))

(defmacro Offcanvas [& body]
  `(dom/div (offcanvas {})
     ~@body))

(defmacro OffcanvasBar [& body]
  `(dom/div (dom/props {:class "uk-offcanvas-bar"})
     ~@body))

(defmacro OffcanvasClose [& body]
  `(dom/button (dom/props {:class "uk-offcanvas-close" :type "button" :uk-close ""})
     ~@body))

(defmacro offcanvas-show [offcanvas]
  `(.show offcanvas))

(defmacro offcanvas-hide [offcanvas]
  `(.hide offcanvas))

(defmacro Overlay [& body]
  `(dom/div (dom/props {:class "uk-overlay"})
     ~@body))

(defmacro overlay-default []
  `(dom/props {:class "uk-overlay-default"}))
(defmacro overlay-primary []
  `(dom/props {:class "uk-overlay-primary"}))

(defmacro Pagination [& body]
  `(dom/ul (dom/props {:class "uk-pagination"})
     ~@body))

(defmacro PaginationItem [& body]
  `(dom/li ~@body))

(defmacro PaginationPrevious [& body]
  `(dom/span (dom/props {:uk-pagination-previous ""})
     ~@body))

(defmacro PaginationNext [& body]
  `(dom/span (dom/props {:uk-pagination-next ""})
     ~@body))

(defmacro Placeholder [& body]
  `(dom/div (dom/props {:class "uk-placeholder"})
     ~@body))

(defmacro position-center []
  `(dom/props {:class "uk-position-center"}))
(defmacro position-top []
  `(dom/props {:class "uk-position-top"}))
(defmacro position-bottom []
  `(dom/props {:class "uk-position-bottom"}))
(defmacro position-left []
  `(dom/props {:class "uk-position-left"}))
(defmacro position-right []
  `(dom/props {:class "uk-position-right"}))

(defmacro PositionCenter [& body]
  `(dom/div (position-center)
     ~@body))

(defmacro PositionTop [& body]
  `(dom/div (position-top)
     ~@body))

(defmacro PositionBottom [& body]
  `(dom/div (position-bottom)
     ~@body))

(defmacro PositionLeft [& body]
  `(dom/div (position-left)
     ~@body))

(defmacro PositionRight [& body]
  `(dom/div (position-right)
     ~@body))

(defmacro position-top-left []
  `(dom/props {:class "uk-position-top-left"}))

(defmacro position-top-center []
  `(dom/props {:class "uk-position-top-center"}))

(defmacro position-top-right []
  `(dom/props {:class "uk-position-top-right"}))

(defmacro position-center []
  `(dom/props {:class "uk-position-center"}))

(defmacro position-center-left []
  `(dom/props {:class "uk-position-center-left"}))

(defmacro position-center-right []
  `(dom/props {:class "uk-position-center-right"}))

(defmacro position-bottom-left []
  `(dom/props {:class "uk-position-bottom-left"}))

(defmacro position-bottom-center []
  `(dom/props {:class "uk-position-bottom-center"}))

(defmacro position-bottom-right []
  `(dom/props {:class "uk-position-bottom-right"}))


(defmacro PositionTopLeft [& body]
  `(dom/div (position-top-left)
     ~@body))

(defmacro PositionTopCenter [& body]
  `(dom/div (position-top-center)
     ~@body))

(defmacro PositionTopRight [& body]
  `(dom/div (position-top-right)
     ~@body))

(defmacro PositionCenterLeft [& body]
  `(dom/div (position-center-left)
     ~@body))

(defmacro PositionCenterRight [& body]
  `(dom/div (position-center-right)
     ~@body))

(defmacro PositionBottomLeft [& body]
  `(dom/div (position-bottom-left)
     ~@body))

(defmacro PositionBottomCenter [& body]
  `(dom/div (position-bottom-center)
     ~@body))

(defmacro PositionBottomRight [& body]
  `(dom/div (position-bottom-right)
     ~@body))

(defmacro position-small []
  `(dom/props {:class "uk-position-small"}))

(defmacro position-medium []
  `(dom/props {:class "uk-position-medium"}))

(defmacro position-large []
  `(dom/props {:class "uk-position-large"}))

(defmacro position-relative []
  `(dom/props {:class "uk-position-relative"}))
(defmacro position-absolute []
  `(dom/props {:class "uk-position-absolute"}))
(defmacro position-fixed []
  `(dom/props {:class "uk-position-fixed"}))
(defmacro position-z-index []
  `(dom/props {:class "uk-position-z-index"}))

(defmacro Progress [& body]
  `(dom/progress (dom/props {:class "uk-progress"})
     ~@body))

(defmacro SlidenavPrevious [& body]
  `(dom/a (dom/props {:uk-slidenav-previous ""})
     ~@body))

(defmacro SlidenavNext [& body]
  `(dom/a (dom/props {:uk-slidenav-next ""})
     ~@body))

(defmacro slidenav-large []
  `(dom/props {:class "uk-slidenav-large"}))

(defmacro SlidenavContainer [& body]
  `(dom/div (dom/props {:class "uk-slidenav-container"})
     ~@body))

(defmacro slider [opts]
  `(let [opts# ~opts
         center# (get opts# :center)
         autoplay# (get opts# :autoplay)
         finite# (get opts# :finite)
         sets# (get opts# :sets)]
     (dom/props {:uk-slider (cond-> ""
                              (some? center#) (str "center: " center# ";")
                              (some? autoplay#) (str "autoplay: " autoplay# ";")
                              (some? finite#) (str "finite: " finite# ";")
                              (some? sets#) (str "sets: " sets# ";"))})))

(defmacro Slider [& body]
  `(dom/div (slider {})
     ~@body))

(defmacro SliderContainer [& body]
  `(dom/div (dom/props {:class "uk-slider-container"})
     ~@body))

(defmacro SliderItems [& body]
  `(dom/ul (dom/props {:class "uk-slider-items"})
     ~@body))

(defmacro slider-nav []
  `(dom/props {:class "uk-slider-nav"}))


(defmacro slider-parallax [opts]
  `(dom/props {:uk-slider-parallax ~opts}))

(defmacro slideshow [opts]
  `(let [opts# ~opts
         animation# (get opts# :animation)
         finite# (get opts# :finite)
         autoplay# (get opts# :autoplay)
         ratio# (get opts# :ratio)
         min-height# (get opts# :min-height)
         max-height# (get opts# :max-height)]
     (dom/props {:uk-slideshow (cond-> ""
                                 (some? animation#) (str "animation: " animation# ";")
                                 (some? autoplay#) (str "autoplay: " autoplay# ";")
                                 (some? finite#) (str "finite: " finite# ";")
                                 (some? ratio#) (str "ratio: " ratio# ";")
                                 (some? min-height#) (str "min-height: " min-height# ";")
                                 (some? max-height#) (str "max-height: " max-height# ";"))})))

(defmacro Slideshow [& body]
  `(dom/div (slideshow {})
     ~@body))

(defmacro SlideshowItems [& body]
  `(dom/div (dom/props {:class "uk-slideshow-items"})
     ~@body))

(defmacro slideshow-item [opts]
  `(dom/props {:uk-slideshow-item (name ~opts)}))
(defmacro slider-parallax [opts]
  `(dom/props {:uk-slider-parallax ~opts}))
(defmacro slideshow-nav []
  `(dom/props {:class "uk-slideshow-nav"}))

(defmacro sortable [opts]
  `(let [opts# ~opts
         handle# (get opts# :handle)
         group# (get opts# :group)
         cls-custom# (get opts# :cls-custom)]
     (dom/props {:uk-sortable (cond-> ""
                                (some? handle#) (str "handle: " handle# ";")
                                (some? group#) (str "group: " group# ";")
                                (some? cls-custom#) (str "cls-custom: " cls-custom# ";"))})))

(defmacro Sortable [& body]
  `(dom/div (sortable {})
     ~@body))

(defmacro spinner [opts]
  `(let [opts# ~opts
         ratio# (get opts# :ratio)]
     (dom/props {:uk-spinner (cond-> ""
                               (some? ratio#) (str "ratio: " ratio# ";"))})))

(defmacro Sortable [& body]
  `(dom/div (spinner {})
     ~@body))

(defmacro sticky [opts]
  `(let [opts# ~opts
         position# (get opts# :position)
         start# (get opts# :start)
         end# (get opts# :end)
         offset# (get opts# :offset)
         animation# (get opts# :animation)
         show-on-up# (get opts# :show-on-up)
         media# (get opts# :media)
         overflow-flip# (get opts# :overflow-flip)]
     (dom/props {:uk-sticky (cond-> ""
                              (some? position#) (str "position: " position# ";")
                              (some? start#) (str "start: " start# ";")
                              (some? end#) (str "end: " end# ";")
                              (some? offset#) (str "offset: " offset# ";")
                              (some? animation#) (str "animation: " animation# ";")
                              (some? overflow-flip#) (str "overflow-flip: " overflow-flip# ";")
                              (some? media#) (str "media: " media# ";")
                              (some? show-on-up#) (str "show-on-up: " show-on-up# ";"))})))

(defmacro Sticky [& body]
  `(dom/div (sticky {})
     ~@body))

(defmacro svg [opts]
  `(let [opts# ~opts
         stroke-animation# (get opts# :stroke-animation)]
     (dom/props {:uk-svg (cond-> ""
                           (some? stroke-animation#) (str "stroke-animation: " stroke-animation# ";"))})))

(defmacro Svg [& body]
  `(dom/img (svg {})
     ~@body))

(defmacro switcher [opts]
  `(let [opts# ~opts
         connect# (get opts# :connect)
         animation# (get opts# :animation)]
     (dom/props {:uk-switcher (cond-> ""
                                (some? animation#) (str "animation: " animation# ";")
                                (some? connect#) (str "connect: " connect# ";"))})))

(defmacro Switcher [& body]
  `(dom/ul (switcher {})
     ~@body))

(defmacro switcher-item [opts]
  `(dom/props {:uk-switcher ~opts}))
(defmacro switcher-show [el idx]
  `(.show el idx))

(defmacro tab [opts]
  `(dom/props {:uk-tab ""}))

(defmacro Tab [& body]
  `(dom/ul (tab {})
     ~@body))

(defmacro tab-alt []
  `(dom/props {:class "uk-tab-alt"}))
(defmacro tab-bottom []
  `(dom/props {:class "uk-tab-bottom"}))
(defmacro tab-left []
  `(dom/props {:class "uk-tab-left"}))
(defmacro tab-right []
  `(dom/props {:class "uk-tab-right"}))

(defmacro flex-right []
  `(dom/props {:class "uk-flex-right"}))

(defmacro Table [& body]
  `(dom/table (dom/props {:class "uk-table"})
     ~@body))

(defmacro table-divider []
  `(dom/props {:class "uk-table-divider"}))
(defmacro table-stripped []
  `(dom/props {:class "uk-table-stripped"}))
(defmacro table-hover []
  `(dom/props {:class "uk-table-hover"}))
(defmacro table-justify []
  `(dom/props {:class "uk-table-justify"}))
(defmacro table-middle []
  `(dom/props {:class "uk-table-middle"}))
(defmacro table-responsive []
  `(dom/props {:class "uk-table-responsive"}))
(defmacro table-shrink []
  `(dom/props {:class "uk-table-shrink"}))
(defmacro table-expand []
  `(dom/props {:class "uk-table-expand"}))
(defmacro table-link []
  `(dom/props {:class "uk-table-link"}))

(defmacro Thumbnav [& body]
  `(dom/ul (dom/props {:class "uk-thumbnav"})
     ~@body))

(defmacro thumbnav-vertical []
  `(dom/props {:class "uk-thumbnav-vertical"}))

(defmacro tooltip [opts]
  `(let [opts# ~opts
         title# (get opts# :title)
         pos# (get opts# :pos)
         delay# (get opts# :delay)]
     (dom/props {:uk-tooltip (cond-> ""
                               (some? delay#) (str "delay: " delay# ";")
                               (some? pos#) (str "pos: " pos# ";")
                               (some? title#) (str "title: " title# ";"))})))

(defmacro Tooltip [title & body]
  `(dom/div (tooltip {:title ~title})
     ~@body))

(defmacro totop []
  `(dom/props {:uk-totop ""}))

(defmacro Totop [& body]
  `(dom/a (totop) ~@body))

(defmacro transition-toggle []
  `(dom/props {:class "uk-transition-toggle"}))





(defmacro transition-fade []
  `(dom/props {:class "uk-transition-fade"}))
(defmacro transition-scale-up []
  `(dom/props {:class "uk-transition-scale-up"}))
(defmacro transition-scale-down []
  `(dom/props {:class "uk-transition-scale-down"}))
(defmacro transition-slide-top []
  `(dom/props {:class "uk-transition-slide-top"}))
(defmacro transition-slide-bottom []
  `(dom/props {:class "uk-transition-slide-bottom"}))
(defmacro transition-slide-left []
  `(dom/props {:class "uk-transition-slide-left"}))
(defmacro transition-slide-right []
  `(dom/props {:class "uk-transition-slide-right"}))
(defmacro transition-slide-top-small []
  `(dom/props {:class "uk-transition-slide-top-small"}))
(defmacro transition-slide-bottom-small []
  `(dom/props {:class "uk-transition-slide-bottom-small"}))
(defmacro transition-slide-left-small []
  `(dom/props {:class "uk-transition-slide-left-small"}))
(defmacro transition-slide-right-small []
  `(dom/props {:class "uk-transition-slide-right-small"}))
(defmacro transition-slide-top-medium []
  `(dom/props {:class "uk-transition-slide-top-medium"}))
(defmacro transition-slide-bottom-medium []
  `(dom/props {:class "uk-transition-slide-bottom-medium"}))
(defmacro transition-slide-left-medium []
  `(dom/props {:class "uk-transition-slide-left-medium"}))
(defmacro transition-slide-right-medium []
  `(dom/props {:class "uk-transition-slide-right-medium"}))

(defmacro panel []
  `(dom/props {:class "uk-panel"}))
(defmacro panel-scrollable []
  `(dom/props {:class "uk-panel-scrollable"}))

(defmacro Panel [& body]
  `(dom/div (panel) ~@body))

(defmacro PanelScrollable [& body]
  `(Panel (panel-scrollable) ~@body))

(defmacro float-left []
  `(dom/props {:class "uk-float-left"}))
(defmacro float-right []
  `(dom/props {:class "uk-float-right"}))
(defmacro clearfix []
  `(dom/props {:class "uk-clearfix"}))

(defmacro overflow-auto []
  `(dom/props {:class "uk-overflow-auto"}))
(defmacro overflow-hidden []
  `(dom/props {:class "uk-overflow-hidden"}))

(defmacro resize []
  `(dom/props {:class "uk-resize"}))
(defmacro resize-vertical []
  `(dom/props {:class "uk-resize-vertical"}))

(defmacro display-block []
  `(dom/props {:class "uk-display-block"}))
(defmacro display-inline []
  `(dom/props {:class "uk-display-inline"}))
(defmacro display-inline-bloc []
  `(dom/props {:class "uk-display-inline-bloc"}))

(defmacro inline []
  `(dom/props {:class "uk-inline"}))
(defmacro inline-clip []
  `(dom/props {:class "uk-inline-clip"}))

(defmacro Inline [& body]
  `(dom/div (inline) ~@body))

(defmacro InlineClip [& body]
  `(dom/div (inline-clip) ~@body))

(defmacro responsive-width []
  `(dom/props {:class "uk-responsive-width"}))
(defmacro responsive-height []
  `(dom/props {:class "uk-responsive-height"}))
(defmacro preserve-width []
  `(dom/props {:class "uk-preserve-width"}))


(defmacro object-cover []
  `(dom/props {:class "uk-object-cover"}))
(defmacro object-contain []
  `(dom/props {:class "uk-object-contain"}))
(defmacro object-fill []
  `(dom/props {:class "uk-object-fill"}))
(defmacro object-none []
  `(dom/props {:class "uk-object-none"}))
(defmacro object-scale-dow []
  `(dom/props {:class "uk-object-scale-dow"}))

(defmacro object-position-top-left []
  `(dom/props {:class "uk-object-position-top-left"}))
(defmacro object-position-top-center []
  `(dom/props {:class "uk-object-position-top-center"}))
(defmacro object-position-top-right []
  `(dom/props {:class "uk-object-position-top-right"}))
(defmacro object-position-center-left []
  `(dom/props {:class "uk-object-position-center-left"}))
(defmacro object-position-center-center []
  `(dom/props {:class "uk-object-position-center-center"}))
(defmacro object-position-center-right []
  `(dom/props {:class "uk-object-position-center-right"}))
(defmacro object-position-bottom-left []
  `(dom/props {:class "uk-object-position-bottom-left"}))
(defmacro object-position-bottom-center []
  `(dom/props {:class "uk-object-position-bottom-center"}))
(defmacro object-position-bottom-right []
  `(dom/props {:class "uk-object-position-bottom-right"}))

(defmacro border-rounded []
  `(dom/props {:class "uk-border-rounded"}))
(defmacro border-circle []
  `(dom/props {:class "uk-border-circle"}))
(defmacro border-pill []
  `(dom/props {:class "uk-border-pill"}))

(defmacro box-shadow-small []
  `(dom/props {:class "uk-box-shadow-small"}))
(defmacro box-shadow-medium []
  `(dom/props {:class "uk-box-shadow-medium"}))
(defmacro box-shadow-large []
  `(dom/props {:class "uk-box-shadow-large"}))
(defmacro box-shadow-xlarge []
  `(dom/props {:class "uk-box-shadow-xlarge"}))

(defmacro box-shadow-bottom []
  `(dom/props {:class "uk-box-shadow-bottom"}))
(defmacro box-shadow-hover-small []
  `(dom/props {:class "uk-box-shadow-hover-small"}))

(defmacro dropcap []
  `(dom/props {:class "uk-dropcap"}))

(defmacro logo []
  `(dom/props {:class "uk-logo"}))

(defmacro Logo [& body]
  `(dom/a (logo) ~@body))

(defmacro padding []
  `(dom/props {:class "uk-padding"}))

(defmacro light []
  `(dom/props {:class "uk-light"}))

(defmacro Light [& body]
  `(dom/div (light)
     ~@body))

(defmacro blend-multiply []
  `(dom/props {:class "uk-blend-multiply"}))
(defmacro blend-screen []
  `(dom/props {:class "uk-blend-screen"}))
(defmacro blend-overlay []
  `(dom/props {:class "uk-blend-overlay"}))
(defmacro blend-darken []
  `(dom/props {:class "uk-blend-darken"}))
(defmacro blend-lighten []
  `(dom/props {:class "uk-blend-lighten"}))
(defmacro blend-color-dodge []
  `(dom/props {:class "uk-blend-color-dodge"}))
(defmacro blend-color-burn []
  `(dom/props {:class "uk-blend-color-burn"}))
(defmacro blend-hard-light []
  `(dom/props {:class "uk-blend-hard-light"}))
(defmacro blend-soft-light []
  `(dom/props {:class "uk-blend-soft-light"}))
(defmacro blend-difference []
  `(dom/props {:class "uk-blend-difference"}))
(defmacro blend-exclusion []
  `(dom/props {:class "uk-blend-exclusion"}))
(defmacro blend-hue []
  `(dom/props {:class "uk-blend-hue"}))
(defmacro blend-saturation []
  `(dom/props {:class "uk-blend-saturation"}))
(defmacro blend-color []
  `(dom/props {:class "uk-blend-color"}))
(defmacro blend-luminosity []
  `(dom/props {:class "uk-blend-luminosity"}))

(defmacro transform-center []
  `(dom/props {:class "uk-transform-center"}))

(defmacro transform-origin-top-left []
  `(dom/props {:class "uk-transform-origin-top-left"}))
(defmacro transform-origin-top-center []
  `(dom/props {:class "uk-transform-origin-top-center"}))
(defmacro transform-origin-top-right []
  `(dom/props {:class "uk-transform-origin-top-right"}))
(defmacro transform-origin-center-left []
  `(dom/props {:class "uk-transform-origin-center-left"}))
(defmacro transform-origin-center-right []
  `(dom/props {:class "uk-transform-origin-center-right"}))
(defmacro transform-origin-bottom-left []
  `(dom/props {:class "uk-transform-origin-bottom-left"}))
(defmacro transform-origin-bottom-center []
  `(dom/props {:class "uk-transform-origin-bottom-center"}))
(defmacro transform-origin-bottom-right []
  `(dom/props {:class "uk-transform-origin-bottom-right"}))

(defmacro drag []
  `(dom/props {:class "uk-drag"}))

(defmacro hidden []
  `(dom/props {:class "uk-hidden"}))
(defmacro invisible []
  `(dom/props {:class "uk-invisible"}))

(defmacro hidden-s []
  `(dom/props {:class "uk-hidden@s"}))
(defmacro hidden-m []
  `(dom/props {:class "uk-hidden@m"}))
(defmacro hidden-l []
  `(dom/props {:class "uk-hidden@l"}))
(defmacro hidden-xl []
  `(dom/props {:class "uk-hidden@xl"}))

(defmacro visible-s []
  `(dom/props {:class "uk-visible@s"}))
(defmacro visible-m []
  `(dom/props {:class "uk-visible@m"}))
(defmacro visible-l []
  `(dom/props {:class "uk-visible@l"}))
(defmacro visible-xl []
  `(dom/props {:class "uk-visible@xl"}))

(defmacro visible-toggle []
  `(dom/props {:class "uk-visible-toggle"}))
(defmacro hidden-hover []
  `(dom/props {:class "uk-hidden-hover"}))
(defmacro invisible-hover []
  `(dom/props {:class "uk-invisible-hover"}))


(defmacro hidden-touch []
  `(dom/props {:class "uk-hidden-touch"}))
(defmacro hidden-notouch []
  `(dom/props {:class "uk-hidden-notouch"}))