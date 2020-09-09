/**
 * Entrypoint of the plugins frontend
 * Written with ReactJS
 */

import React from 'react';
import './style.css';
import HtmlReportApp from './components/HtmlReportApp';

window.registerExtension('htmlreport/report', () => {
    return <HtmlReportApp/>
});