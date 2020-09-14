/**
 * Main JS component of the plugin
 * Written with ReactJS
 */

import React from "react";

import {DeferredSpinner} from "sonar-components";
import {initiatePluginToken} from "../common/api";

export default class QualityReportApp extends React.PureComponent {
    state = {
        loading: true,
        author: "",
        token: ""
    };

    onChangeAuthor = (event) => {
        this.setState({author: event.target.value})
    };

    componentDidMount() {
        initiatePluginToken().then(tokenInfo => {
            this.setState({
                loading: false,
                token: tokenInfo.token,
                author: tokenInfo.author
            });
        });
    }

    render() {
        if (this.state.loading) {
            return <div className="page page-limited"><DeferredSpinner/></div>;
        }

        return (
            <div class="page-wrapper-simple">
                <div class="page-simple">
                    <h1 class="maintenance-title text-center">Generate Quality Report</h1>
                    <form id="generation-form" action="../../api/qualityreport/report" method="get">
                        <div class='forminput'>
                            <label for="author" id="authorLabel" class="login-label"><strong>Author</strong></label>
                            <input type="text"
                                   id="author"
                                   name="author"
                                   class="login-input"
                                   maxlength="255"
                                   required
                                   placeholder="Report's author" value={this.state.author}
                                   onChange={this.onChangeAuthor}/>
                            <input type="hidden" name="token" id="token_qualityreport" defaultValue={this.state.token}/>
                        </div>
                        <br/>
                        <input id="generation" name="generation" type="submit" value="Generate"/><br/>
                        <em class="info-message">This operation may take some time, please wait while the report is
                            being generated.</em>
                    </form>
                </div>
            </div>
        );
    }
}