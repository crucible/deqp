/*-------------------------------------------------------------------------
 * drawElements Quality Program Tester Core
 * ----------------------------------------
 *
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *//*!
 * \file
 * \brief ExecServer Activity
 *
 * Actual execserver is run in service, but this activity serves
 * as starter for the service.
 *//*--------------------------------------------------------------------*/

package com.drawelements.deqp.execserver;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;

import com.drawelements.deqp.testercore.Log;
import com.drawelements.deqp.R;

public class ExecServerActivity extends Activity {

	private static final String		LOG_TAG			= "dEQP/ExecServer";
	private static final int		PORT			= 50016;

	private TextView				m_statusText;

	@Override
	protected void onCreate (Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.exec_server);

		m_statusText = (TextView)findViewById(R.id.status_text);
	}

	@Override
	protected void onStart () {
		super.onStart();

		try {
			Intent svc = new Intent(this, com.drawelements.deqp.execserver.ExecService.class);
			startService(svc);
		}
		catch (Exception e) {
			Log.e(LOG_TAG, "Service starter starting problem", e);
			m_statusText.setText("Failed to start ExecServer!");
		}

		// \todo [2013-05-07 pyry] Show IP address
		m_statusText.setText(String.format("Listening on port %d", PORT));
	}

	@Override
	protected void onStop () {
		super.onStop();
	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	protected void onResume () {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
