package com.example.famouspersonality.models

import androidx.fragment.app.Fragment

data class DrawerMenuItem(
    val title: String,
    val fragment: Fragment?,
    val isExpandable: Boolean = false,
    val subItems: List<ChildMenu> = emptyList(),
    var isExpanded: Boolean = false
)
