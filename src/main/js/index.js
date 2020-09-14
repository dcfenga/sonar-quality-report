/**
 * Entrypoint of the plugins frontend
 * Written with ReactJS
 */

import React from 'react';
import './style.css';
import QualityReportApp from './components/QualityReportApp';

window.registerExtension('qualityreport/report', () => {
    return <QualityReportApp/>
});