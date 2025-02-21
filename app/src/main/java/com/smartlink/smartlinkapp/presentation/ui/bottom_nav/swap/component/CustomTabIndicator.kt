package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.ui.theme.Sunflower_Gold

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomTabIndicator(
    tabsPos: List<TabPosition>,
    pagerState: PagerState,
) {
    val transition =
        updateTransition(targetState = pagerState.currentPageOffsetFraction, label = "")

    val indicatorStart by transition.animateDp(
        transitionSpec = {
            spring(
                dampingRatio = 1f, // Adjust the damping ratio for smoother movement
                stiffness = 400f // Adjust the stiffness for the desired speed of movement
            )
        }, label = ""
    ) {
        // Calculate the left position of the indicator based on the currentPageOffset
        val currentIndex = pagerState.currentPage
        val nextIndex =
            if (pagerState.currentPage < pagerState.pageCount - 1) currentIndex + 1 else currentIndex
        val startX = tabsPos[currentIndex].left
        val endX = tabsPos[nextIndex.coerceAtMost(tabsPos.size - 1)].left
        startX + (endX - startX) * it
    }

    val currentIndex = pagerState.currentPage
    val indicatorWidth = tabsPos[currentIndex].width // Use the width of the current tab


    Box(
        modifier = Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(Alignment.BottomStart)
            .width(indicatorWidth)
            .padding(start = 24.dp, end = 24.dp, top = 2.dp)
            .height(5.dp)
            .background(Sunflower_Gold, RoundedCornerShape(50))
    )
}

