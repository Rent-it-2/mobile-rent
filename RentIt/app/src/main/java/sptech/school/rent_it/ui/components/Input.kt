package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.ui.theme.typography

@Composable
fun Input(
    label: String,
    labelColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    labelStyle: TextStyle = typography.labelLarge,
    value: String,
    onValueChange: (String) -> Unit = {},
    keyBoardType: KeyboardType,
    imeAction: ImeAction,
    focusItem: FocusRequester = FocusRequester(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = label,
            style = labelStyle,
            color = labelColor
        )
//        if (value != null) {
            OutlinedTextField(
                value = value,
                onValueChange = {
                    selectedValue = it
                    onValueChange(it)
                },
                placeholder = placeholder,
                shape = MaterialTheme.shapes.small,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .focusRequester(focusItem),
                keyboardOptions = KeyboardOptions(keyboardType = keyBoardType, imeAction = imeAction),
                keyboardActions = keyboardActions,
                singleLine = true,
                isError = isError,
                visualTransformation = visualTransformation,
                trailingIcon = trailingIcon,
                leadingIcon = leadingIcon
            )
//        }
    }
}