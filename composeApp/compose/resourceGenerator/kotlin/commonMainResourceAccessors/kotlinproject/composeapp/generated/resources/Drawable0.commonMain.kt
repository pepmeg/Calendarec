@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package kotlinproject.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val avatar: DrawableResource by 
      lazy { init_avatar() }

  public val avatars_icon: DrawableResource by 
      lazy { init_avatars_icon() }

  public val bg_element: DrawableResource by 
      lazy { init_bg_element() }

  public val calendar_icon: DrawableResource by 
      lazy { init_calendar_icon() }

  public val compose_multiplatform: DrawableResource by 
      lazy { init_compose_multiplatform() }

  public val ic_task_notification: DrawableResource by 
      lazy { init_ic_task_notification() }

  public val time_icon: DrawableResource by 
      lazy { init_time_icon() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("avatar", CommonMainDrawable0.avatar)
  map.put("avatars_icon", CommonMainDrawable0.avatars_icon)
  map.put("bg_element", CommonMainDrawable0.bg_element)
  map.put("calendar_icon", CommonMainDrawable0.calendar_icon)
  map.put("compose_multiplatform", CommonMainDrawable0.compose_multiplatform)
  map.put("ic_task_notification", CommonMainDrawable0.ic_task_notification)
  map.put("time_icon", CommonMainDrawable0.time_icon)
}

internal val Res.drawable.avatar: DrawableResource
  get() = CommonMainDrawable0.avatar

private fun init_avatar(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:avatar",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/avatar.png", -1, -1),
    )
)

internal val Res.drawable.avatars_icon: DrawableResource
  get() = CommonMainDrawable0.avatars_icon

private fun init_avatars_icon(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:avatars_icon",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/avatars_icon.png", -1, -1),
    )
)

internal val Res.drawable.bg_element: DrawableResource
  get() = CommonMainDrawable0.bg_element

private fun init_bg_element(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:bg_element",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/bg_element.png", -1, -1),
    )
)

internal val Res.drawable.calendar_icon: DrawableResource
  get() = CommonMainDrawable0.calendar_icon

private fun init_calendar_icon(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:calendar_icon",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/calendar_icon.png", -1, -1),
    )
)

internal val Res.drawable.compose_multiplatform: DrawableResource
  get() = CommonMainDrawable0.compose_multiplatform

private fun init_compose_multiplatform(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:compose_multiplatform",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/compose-multiplatform.xml", -1, -1),
    )
)

internal val Res.drawable.ic_task_notification: DrawableResource
  get() = CommonMainDrawable0.ic_task_notification

private fun init_ic_task_notification(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:ic_task_notification",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/ic_task_notification.xml", -1, -1),
    )
)

internal val Res.drawable.time_icon: DrawableResource
  get() = CommonMainDrawable0.time_icon

private fun init_time_icon(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:time_icon",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/kotlinproject.composeapp.generated.resources/drawable/time_icon.png", -1, -1),
    )
)
